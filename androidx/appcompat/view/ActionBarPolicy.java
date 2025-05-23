package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarPolicy {
    private Context mContext;

    ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        if (this.mContext.getApplicationInfo().targetSdkVersion < 14) {
            return true;
        }
        return false;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i16 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i3 <= 600) {
            if (i3 <= 960 || i16 <= 720) {
                if (i3 <= 720 || i16 <= 960) {
                    if (i3 < 500) {
                        if (i3 <= 640 || i16 <= 480) {
                            if (i3 <= 480 || i16 <= 640) {
                                if (i3 >= 360) {
                                    return 3;
                                }
                                return 2;
                            }
                            return 4;
                        }
                        return 4;
                    }
                    return 4;
                }
                return 5;
            }
            return 5;
        }
        return 5;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.bue);
    }

    public int getTabContainerHeight() {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, R.attr.f4195u, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(androidx.appcompat.R.styleable.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        if (!hasEmbeddedTabs()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.bud));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.f156525e);
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
