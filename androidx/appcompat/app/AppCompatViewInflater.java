package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private final Object[] mConstructorArgs = new Object[2];
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final int[] sOnClickAttrs = {R.attr.onClick};
    private static final String[] sClassPrefixList = {"android.widget.", "android.view.", "android.webkit."};
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = new SimpleArrayMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(@NonNull View view, @NonNull String str) {
            this.mHostView = view;
            this.mMethodName = str;
        }

        private void resolveMethod(@Nullable Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, View.class)) != null) {
                        this.mResolvedMethod = method;
                        this.mResolvedContext = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id5 = this.mHostView.getId();
            if (id5 == -1) {
                str = "";
            } else {
                str = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(id5) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NonNull View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.mResolvedMethod == null) {
                resolveMethod(this.mHostView.getContext());
            }
            try {
                this.mResolvedMethod.invoke(this.mResolvedContext, view);
                EventCollector.getInstance().onViewClicked(view);
            } catch (IllegalAccessException e16) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e16);
            } catch (InvocationTargetException e17) {
                throw new IllegalStateException("Could not execute method for android:onClick", e17);
            }
        }
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && ViewCompat.hasOnClickListeners(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, sOnClickAttrs);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new DeclaredOnClickListener(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View createViewByPrefix(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        SimpleArrayMap<String, Constructor<? extends View>> simpleArrayMap = sConstructorMap;
        Constructor<? extends View> constructor = simpleArrayMap.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);
            simpleArrayMap.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, Constants.Service.CLASS);
        }
        try {
            Object[] objArr = this.mConstructorArgs;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                int i3 = 0;
                while (true) {
                    String[] strArr = sClassPrefixList;
                    if (i3 >= strArr.length) {
                        return null;
                    }
                    View createViewByPrefix = createViewByPrefix(context, str, strArr[i3]);
                    if (createViewByPrefix != null) {
                        return createViewByPrefix;
                    }
                    i3++;
                }
            } else {
                return createViewByPrefix(context, str, null);
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.mConstructorArgs;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean z16, boolean z17) {
        int i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.View, 0, 0);
        if (z16) {
            i3 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_android_theme, 0);
        } else {
            i3 = 0;
        }
        if (z17 && i3 == 0 && (i3 = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.View_theme, 0)) != 0) {
            Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        if (i3 != 0) {
            if (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != i3) {
                return new ContextThemeWrapper(context, i3);
            }
            return context;
        }
        return context;
    }

    private void verifyNotNull(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    @NonNull
    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    @NonNull
    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    @NonNull
    protected AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    @NonNull
    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    @NonNull
    protected AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    @NonNull
    protected AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    @NonNull
    protected AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    @NonNull
    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    @NonNull
    protected AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    @Nullable
    protected View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet, boolean z16, boolean z17, boolean z18, boolean z19) {
        View createRatingBar;
        Context context2 = (!z16 || view == null) ? context : view.getContext();
        if (z17 || z18) {
            context2 = themifyContext(context2, attributeSet, z17, z18);
        }
        if (z19) {
            context2 = TintContextWrapper.wrap(context2);
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c16 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c16 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c16 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c16 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c16 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c16 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c16 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c16 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c16 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals(ComponentFactory.ComponentType.BUTTON)) {
                    c16 = '\r';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                createRatingBar = createRatingBar(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 1:
                createRatingBar = createCheckedTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 2:
                createRatingBar = createMultiAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 3:
                createRatingBar = createTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 4:
                createRatingBar = createImageButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 5:
                createRatingBar = createSeekBar(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 6:
                createRatingBar = createSpinner(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 7:
                createRatingBar = createRadioButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case '\b':
                createRatingBar = createToggleButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case '\t':
                createRatingBar = createImageView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case '\n':
                createRatingBar = createAutoCompleteTextView(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case 11:
                createRatingBar = createCheckBox(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case '\f':
                createRatingBar = createEditText(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            case '\r':
                createRatingBar = createButton(context2, attributeSet);
                verifyNotNull(createRatingBar, str);
                break;
            default:
                createRatingBar = createView(context2, str, attributeSet);
                break;
        }
        if (createRatingBar == null && context != context2) {
            createRatingBar = createViewFromTag(context2, str, attributeSet);
        }
        if (createRatingBar != null) {
            checkOnClickListener(createRatingBar, attributeSet);
        }
        return createRatingBar;
    }
}
