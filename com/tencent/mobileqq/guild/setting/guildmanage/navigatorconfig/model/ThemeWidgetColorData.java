package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00072\u00020\u0001:\u0001\u0012B!\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020!\u00a2\u0006\u0004\b0\u00101J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007JL\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t20\b\u0002\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b\u00a2\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0015\u001a\u00020\u0005J\t\u0010\u0017\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u001d\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010 \u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010$R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/d;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/e;", "", "color", "", "d", "f", "e", "Landroid/view/View;", "v", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "customFun", "", "isGetColor", "a", "other", "c", "g", "", "toString", "hashCode", "equals", "I", "getTitleColor", "()I", "titleColor", "b", "getPreviewPlaceHolderBgColor", "previewPlaceHolderBgColor", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/CoverColor;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/CoverColor;", "getCoverColor", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/CoverColor;", "coverColor", "", "Ljava/util/List;", "getTitleColorBindViews", "()Ljava/util/List;", "setTitleColorBindViews", "(Ljava/util/List;)V", "titleColorBindViews", "getPreviewPlaceHolderBgColorBindViews", "setPreviewPlaceHolderBgColorBindViews", "previewPlaceHolderBgColorBindViews", "<init>", "(IILcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/CoverColor;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ThemeWidgetColorData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int titleColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int previewPlaceHolderBgColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CoverColor coverColor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ViewBindModel> titleColorBindViews;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<ViewBindModel> previewPlaceHolderBgColorBindViews;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/d$a;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/model/d;", "b", "a", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.model.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ThemeWidgetColorData a() {
            return new ThemeWidgetColorData(-1, -1, CoverColor.DARK);
        }

        @NotNull
        public final ThemeWidgetColorData b() {
            return new ThemeWidgetColorData(-1, -1, CoverColor.DARK);
        }

        @NotNull
        public final ThemeWidgetColorData c() {
            return new ThemeWidgetColorData(Color.parseColor("#1A1C1E"), -16777216, CoverColor.LIGHT);
        }

        Companion() {
        }
    }

    public ThemeWidgetColorData(int i3, int i16, @NotNull CoverColor coverColor) {
        Intrinsics.checkNotNullParameter(coverColor, "coverColor");
        this.titleColor = i3;
        this.previewPlaceHolderBgColor = i16;
        this.coverColor = coverColor;
        this.titleColorBindViews = new ArrayList();
        this.previewPlaceHolderBgColorBindViews = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(ThemeWidgetColorData themeWidgetColorData, View view, Function2 function2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        themeWidgetColorData.a(view, function2, z16);
    }

    private final void d(ViewBindModel viewBindModel, int i3) {
        if (viewBindModel.a() == null) {
            View view = viewBindModel.getView();
            if (view instanceof TextView) {
                ((TextView) viewBindModel.getView()).setTextColor(i3);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) viewBindModel.getView()).setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
                return;
            } else {
                viewBindModel.getView().setBackgroundColor(i3);
                return;
            }
        }
        viewBindModel.a().invoke(viewBindModel.getView(), Integer.valueOf(i3));
    }

    @UiThread
    public final void a(@NotNull View v3, @Nullable Function2<? super View, ? super Integer, Unit> customFun, boolean isGetColor) {
        Intrinsics.checkNotNullParameter(v3, "v");
        ViewBindModel viewBindModel = new ViewBindModel(v3, customFun);
        if (isGetColor) {
            d(viewBindModel, this.titleColor);
        }
        this.titleColorBindViews.add(viewBindModel);
    }

    @NotNull
    public final ThemeWidgetColorData c(@NotNull ThemeWidgetColorData other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.titleColorBindViews = other.titleColorBindViews;
        this.previewPlaceHolderBgColorBindViews = other.previewPlaceHolderBgColorBindViews;
        return this;
    }

    @UiThread
    public final void e() {
        Iterator<T> it = this.previewPlaceHolderBgColorBindViews.iterator();
        while (it.hasNext()) {
            d((ViewBindModel) it.next(), this.previewPlaceHolderBgColor);
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThemeWidgetColorData)) {
            return false;
        }
        ThemeWidgetColorData themeWidgetColorData = (ThemeWidgetColorData) other;
        if (this.titleColor == themeWidgetColorData.titleColor && this.previewPlaceHolderBgColor == themeWidgetColorData.previewPlaceHolderBgColor && this.coverColor == themeWidgetColorData.coverColor) {
            return true;
        }
        return false;
    }

    @UiThread
    public final void f() {
        Iterator<T> it = this.titleColorBindViews.iterator();
        while (it.hasNext()) {
            d((ViewBindModel) it.next(), this.titleColor);
        }
    }

    public final void g() {
        this.titleColorBindViews.clear();
        this.previewPlaceHolderBgColorBindViews.clear();
    }

    public int hashCode() {
        return (((this.titleColor * 31) + this.previewPlaceHolderBgColor) * 31) + this.coverColor.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThemeWidgetColorData(titleColor=" + this.titleColor + ", previewPlaceHolderBgColor=" + this.previewPlaceHolderBgColor + ", coverColor=" + this.coverColor + ")";
    }
}
