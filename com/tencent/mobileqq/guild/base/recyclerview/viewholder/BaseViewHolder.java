package com.tencent.mobileqq.guild.base.recyclerview.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ#\u0010\f\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\r\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0010\u001a\u00020\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u001d\u001a\u00020\nH\u0016J\u001c\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010!\u001a\u00020\nH\u0016J\u001c\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010#\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010$\u001a\u00020\nH\u0016J\u001a\u0010%\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0013H\u0016J\u001d\u0010'\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u0003*\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "views", "Landroid/util/SparseArray;", "getView", "T", "viewId", "", "(I)Landroid/view/View;", "getViewOrNull", "setBackgroundColor", "color", "setBackgroundResource", "backgroundRes", "setEnabled", "isEnabled", "", "setGone", "isGone", "setImageBitmap", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImageResource", "imageResId", IECSearchBar.METHOD_SET_TEXT, "value", "", "strId", "setTextColor", "setTextColorRes", "colorRes", "setVisible", "isVisible", "findView", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    @NotNull
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.views = new SparseArray<>();
    }

    @Nullable
    public <T extends View> T findView(int i3) {
        return (T) this.itemView.findViewById(i3);
    }

    @NotNull
    public <T extends View> T getView(@IdRes int viewId) {
        T t16 = (T) getViewOrNull(viewId);
        if (t16 != null) {
            return t16;
        }
        throw new IllegalStateException(("No view found with id " + viewId).toString());
    }

    @Nullable
    public <T extends View> T getViewOrNull(@IdRes int viewId) {
        T t16;
        T t17 = (T) this.views.get(viewId);
        if (t17 == null && (t16 = (T) this.itemView.findViewById(viewId)) != null) {
            this.views.put(viewId, t16);
            return t16;
        }
        if (t17 == null) {
            return null;
        }
        return t17;
    }

    @NotNull
    public BaseViewHolder setBackgroundColor(@IdRes int viewId, @ColorInt int color) {
        getView(viewId).setBackgroundColor(color);
        return this;
    }

    @NotNull
    public BaseViewHolder setBackgroundResource(@IdRes int viewId, @DrawableRes int backgroundRes) {
        getView(viewId).setBackgroundResource(backgroundRes);
        return this;
    }

    @NotNull
    public BaseViewHolder setEnabled(@IdRes int viewId, boolean isEnabled) {
        getView(viewId).setEnabled(isEnabled);
        return this;
    }

    @NotNull
    public BaseViewHolder setGone(@IdRes int viewId, boolean isGone) {
        int i3;
        View view = getView(viewId);
        if (isGone) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        view.setVisibility(i3);
        return this;
    }

    @NotNull
    public BaseViewHolder setImageBitmap(@IdRes int viewId, @Nullable Bitmap bitmap) {
        ((ImageView) getView(viewId)).setImageBitmap(bitmap);
        return this;
    }

    @NotNull
    public BaseViewHolder setImageDrawable(@IdRes int viewId, @Nullable Drawable drawable) {
        ((ImageView) getView(viewId)).setImageDrawable(drawable);
        return this;
    }

    @NotNull
    public BaseViewHolder setImageResource(@IdRes int viewId, @DrawableRes int imageResId) {
        ((ImageView) getView(viewId)).setImageResource(imageResId);
        return this;
    }

    @NotNull
    public BaseViewHolder setText(@IdRes int viewId, @Nullable CharSequence value) {
        ((TextView) getView(viewId)).setText(value);
        return this;
    }

    @NotNull
    public BaseViewHolder setTextColor(@IdRes int viewId, @ColorInt int color) {
        ((TextView) getView(viewId)).setTextColor(color);
        return this;
    }

    @NotNull
    public BaseViewHolder setTextColorRes(@IdRes int viewId, @ColorRes int colorRes) {
        ((TextView) getView(viewId)).setTextColor(this.itemView.getResources().getColor(colorRes));
        return this;
    }

    @NotNull
    public BaseViewHolder setVisible(@IdRes int viewId, boolean isVisible) {
        int i3;
        View view = getView(viewId);
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        view.setVisibility(i3);
        return this;
    }

    @Nullable
    public BaseViewHolder setText(@IdRes int viewId, @StringRes int strId) {
        ((TextView) getView(viewId)).setText(strId);
        return this;
    }
}
