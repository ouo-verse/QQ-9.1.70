package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import com.tencent.oskplayer.datasource.RawResourceDataSource;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: P */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private static final boolean DBG = false;
    static final int INVALID_INDEX = -1;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    static final int REFINE_ALL = 2;
    static final int REFINE_BY_ENTRY = 1;
    static final int REFINE_NONE = 0;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(R.id.text1);
            this.mText2 = (TextView) view.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) view.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) view.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) view.findViewById(com.tencent.mobileqq.R.id.uql);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.mClosed = false;
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    private Drawable checkIconCache(String str) {
        Drawable.ConstantState constantState = this.mOutsideDrawablesCache.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        if (this.mUrlColor == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.bfw, typedValue, true);
            this.mUrlColor = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.mUrlColor, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w(LOG_TAG, "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e16) {
            Log.w(LOG_TAG, e16.toString());
            return null;
        }
    }

    private Drawable getActivityIconWithCache(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.mOutsideDrawablesCache.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.mProviderContext.getResources());
        }
        Drawable activityIcon = getActivityIcon(componentName);
        if (activityIcon != null) {
            constantState = activityIcon.getConstantState();
        }
        this.mOutsideDrawablesCache.put(flattenToShortString, constantState);
        return activityIcon;
    }

    public static String getColumnString(Cursor cursor, String str) {
        return getStringOrNull(cursor, cursor.getColumnIndex(str));
    }

    private Drawable getDefaultIcon1() {
        Drawable activityIconWithCache = getActivityIconWithCache(this.mSearchable.getSearchActivity());
        if (activityIconWithCache != null) {
            return activityIconWithCache;
        }
        return this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable getDrawable(Uri uri) {
        try {
            if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(uri.getScheme())) {
                try {
                    return getDrawableFromResourceUri(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.mProviderContext.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    return Drawable.createFromStream(openInputStream, null);
                } finally {
                    try {
                        openInputStream.close();
                    } catch (IOException e16) {
                        Log.e(LOG_TAG, "Error closing icon stream for " + uri, e16);
                    }
                }
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e17) {
            Log.w(LOG_TAG, "Icon not found: " + uri + ", " + e17.getMessage());
            return null;
        }
        Log.w(LOG_TAG, "Icon not found: " + uri + ", " + e17.getMessage());
        return null;
    }

    private Drawable getDrawableFromResourceValue(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.mProviderContext.getPackageName() + "/" + parseInt;
            Drawable checkIconCache = checkIconCache(str2);
            if (checkIconCache != null) {
                return checkIconCache;
            }
            Drawable drawable = ContextCompat.getDrawable(this.mProviderContext, parseInt);
            storeInIconCache(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w(LOG_TAG, "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable checkIconCache2 = checkIconCache(str);
            if (checkIconCache2 != null) {
                return checkIconCache2;
            }
            Drawable drawable2 = getDrawable(Uri.parse(str));
            storeInIconCache(str, drawable2);
            return drawable2;
        }
    }

    private Drawable getIcon1(Cursor cursor) {
        int i3 = this.mIconName1Col;
        if (i3 == -1) {
            return null;
        }
        Drawable drawableFromResourceValue = getDrawableFromResourceValue(cursor.getString(i3));
        if (drawableFromResourceValue != null) {
            return drawableFromResourceValue;
        }
        return getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor cursor) {
        int i3 = this.mIconName2Col;
        if (i3 == -1) {
            return null;
        }
        return getDrawableFromResourceValue(cursor.getString(i3));
    }

    private static String getStringOrNull(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e16) {
            Log.e(LOG_TAG, "unexpected error retrieving valid column from cursor, did the remote process die?", e16);
            return null;
        }
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable, int i3) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i3);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void storeInIconCache(String str, Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
        }
    }

    private void updateSpinnerState(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        int i3;
        CharSequence stringOrNull;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i16 = this.mFlagsCol;
        if (i16 != -1) {
            i3 = cursor.getInt(i16);
        } else {
            i3 = 0;
        }
        if (childViewCache.mText1 != null) {
            setViewText(childViewCache.mText1, getStringOrNull(cursor, this.mText1Col));
        }
        if (childViewCache.mText2 != null) {
            String stringOrNull2 = getStringOrNull(cursor, this.mText2UrlCol);
            if (stringOrNull2 != null) {
                stringOrNull = formatUrl(stringOrNull2);
            } else {
                stringOrNull = getStringOrNull(cursor, this.mText2Col);
            }
            if (TextUtils.isEmpty(stringOrNull)) {
                TextView textView = childViewCache.mText1;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.mText1.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.mText1;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.mText1.setMaxLines(1);
                }
            }
            setViewText(childViewCache.mText2, stringOrNull);
        }
        ImageView imageView = childViewCache.mIcon1;
        if (imageView != null) {
            setViewDrawable(imageView, getIcon1(cursor), 4);
        }
        ImageView imageView2 = childViewCache.mIcon2;
        if (imageView2 != null) {
            setViewDrawable(imageView2, getIcon2(cursor), 8);
        }
        int i17 = this.mQueryRefinement;
        if (i17 != 2 && (i17 != 1 || (i3 & 1) == 0)) {
            childViewCache.mIconRefine.setVisibility(8);
            return;
        }
        childViewCache.mIconRefine.setVisibility(0);
        childViewCache.mIconRefine.setTag(childViewCache.mText1.getText());
        childViewCache.mIconRefine.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w(LOG_TAG, "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e16) {
            Log.e(LOG_TAG, "error changing cursor and caching columns", e16);
        }
    }

    public void close() {
        changeCursor(null);
        this.mClosed = true;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String columnString;
        String columnString2;
        if (cursor == null) {
            return null;
        }
        String columnString3 = getColumnString(cursor, "suggest_intent_query");
        if (columnString3 != null) {
            return columnString3;
        }
        if (this.mSearchable.shouldRewriteQueryFromData() && (columnString2 = getColumnString(cursor, "suggest_intent_data")) != null) {
            return columnString2;
        }
        if (!this.mSearchable.shouldRewriteQueryFromText() || (columnString = getColumnString(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return columnString;
    }

    Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e16) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e16);
            View newDropDownView = newDropDownView(this.mContext, this.mCursor, viewGroup);
            if (newDropDownView != null) {
                ((ChildViewCache) newDropDownView.getTag()).mText1.setText(e16.toString());
            }
            return newDropDownView;
        }
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str, int i3) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i3 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i3));
        }
        return ContactsMonitor.query(this.mContext.getContentResolver(), fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        try {
            view2 = super.getView(i3, view, viewGroup);
        } catch (RuntimeException e16) {
            Log.w(LOG_TAG, "Search suggestions cursor threw exception.", e16);
            View newView = newView(this.mContext, this.mCursor, viewGroup);
            if (newView != null) {
                ((ChildViewCache) newView.getTag()).mText1.setText(e16.toString());
            }
            view2 = newView;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new ChildViewCache(newView));
        ((ImageView) newView.findViewById(com.tencent.mobileqq.R.id.uql)).setImageResource(this.mCommitIconResId);
        return newView;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        updateSpinnerState(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        updateSpinnerState(getCursor());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (this.mSearchView.getVisibility() == 0 && this.mSearchView.getWindowVisibility() == 0) {
            try {
                Cursor searchManagerSuggestions = getSearchManagerSuggestions(this.mSearchable, charSequence2, 50);
                if (searchManagerSuggestions != null) {
                    searchManagerSuggestions.getCount();
                    return searchManagerSuggestions;
                }
            } catch (RuntimeException e16) {
                Log.w(LOG_TAG, "Search suggestions query threw an exception.", e16);
            }
        }
        return null;
    }

    public void setQueryRefinement(int i3) {
        this.mQueryRefinement = i3;
    }
}
