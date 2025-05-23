package com.tencent.mobileqq.util.conversationtitlebutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J4\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016JN\u0010 \u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132<\u0010\u0018\u001a8\u0012\u0013\u0012\u00110\u001c\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u001e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00070\u001bH\u0016J \u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001cH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "", "callback", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", DownloadInfo.spKey_Config, "onButtonDidShow", "needCustomizeRedDot", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfoForRedPoint", "needClear", "refreshRedDot", "Landroid/content/Context;", "context", "appInfoForTip", "", "Landroid/graphics/drawable/Drawable;", "cb", "getAvatarDrawableList", "needCustomizeTips", "Lkotlin/Function2;", "", "tip", "", "avatars", "getCustomTips", "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "buttonState", WadlProxyConsts.KEY_JUMP_URL, "handleIconClick", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        public static void a(@NotNull g gVar, @NotNull Context context, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, @NotNull Function1<? super Drawable[], Unit> cb5) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cb5, "cb");
            cb5.invoke(new Drawable[0]);
        }

        public static void b(@NotNull g gVar, @NotNull Context context, @NotNull Function2<? super String, ? super List<? extends Drawable>, Unit> cb5) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cb5, "cb");
        }

        public static boolean c(@NotNull g gVar, @NotNull TitleButtonState buttonState, @NotNull Context context, @NotNull String jumpUrl) {
            Intrinsics.checkNotNullParameter(buttonState, "buttonState");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            return false;
        }

        public static boolean d(@NotNull g gVar) {
            return false;
        }

        public static boolean e(@NotNull g gVar) {
            return false;
        }

        public static void f(@NotNull g gVar, @NotNull ConversationTitleBtnConfig config) {
            Intrinsics.checkNotNullParameter(config, "config");
        }

        public static void g(@NotNull g gVar, @NotNull RedTouch redTouch, @NotNull BusinessInfoCheckUpdate.AppInfo appInfoForRedPoint, boolean z16) {
            Intrinsics.checkNotNullParameter(redTouch, "redTouch");
            Intrinsics.checkNotNullParameter(appInfoForRedPoint, "appInfoForRedPoint");
        }
    }

    void getAvatarDrawableList(@NotNull Context context, @Nullable BusinessInfoCheckUpdate.AppInfo appInfoForTip, @NotNull Function1<? super Drawable[], Unit> cb5);

    void getCustomTips(@NotNull Context context, @NotNull Function2<? super String, ? super List<? extends Drawable>, Unit> cb5);

    boolean handleIconClick(@NotNull TitleButtonState buttonState, @NotNull Context context, @NotNull String jumpUrl);

    void isSupport(@NotNull Function1<? super Boolean, Unit> callback);

    boolean needCustomizeRedDot();

    boolean needCustomizeTips();

    void onButtonDidShow(@NotNull ConversationTitleBtnConfig config);

    void refreshRedDot(@NotNull RedTouch redTouch, @NotNull BusinessInfoCheckUpdate.AppInfo appInfoForRedPoint, boolean needClear);
}
