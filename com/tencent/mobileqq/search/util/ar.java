package com.tencent.mobileqq.search.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ar {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends QUISearchBarResource {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f285017a;

        a(boolean z16) {
            this.f285017a = z16;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getBackground(@NonNull QUISearchBar qUISearchBar) {
            boolean z16;
            if (QQTheme.isVasTheme()) {
                return ResourcesCompat.getDrawable(qUISearchBar.getResources(), R.drawable.skin_searchbar_bg_theme_version2, null);
            }
            if (this.f285017a) {
                return super.getBackground(qUISearchBar);
            }
            Object tag = qUISearchBar.getTag(R.id.f166947jb4);
            boolean z17 = false;
            if (tag != null) {
                z16 = ((Boolean) tag).booleanValue();
            } else {
                z16 = false;
            }
            MainResourceConfig g16 = MainResourceConfig.g();
            Context context = qUISearchBar.getContext();
            if (qUISearchBar.getCurColorType() == 1) {
                z17 = true;
            }
            return g16.m(context, z17, 1.0f, z16);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public Drawable getInputBackground(@NonNull QUISearchBar qUISearchBar) {
            if (QQTheme.isVasTheme()) {
                return ResourcesCompat.getDrawable(qUISearchBar.getResources(), R.drawable.skin_searchbar_input_theme_version2, null);
            }
            return super.getInputBackground(qUISearchBar);
        }
    }

    public static QUISearchBarResource a() {
        return b(true);
    }

    public static QUISearchBarResource b(boolean z16) {
        return new a(z16);
    }
}
