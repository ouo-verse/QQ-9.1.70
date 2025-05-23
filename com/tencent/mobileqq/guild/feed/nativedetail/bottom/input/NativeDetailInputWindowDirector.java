package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.AtButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.EditTextInputActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.EmojiPanelCallbackActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.NewLineCompatActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.PicButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SelectPicActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SendButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SyncToTroopSwitcherActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.j;
import com.tencent.mobileqq.guild.feed.util.framework.route.InterfaceRouterImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ?2\u00020\u0001:\u0005(,1U\u0006B\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0002J \u0010#\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010$\u001a\u00020\u0002R \u0010*\u001a\f\u0012\u0004\u0012\u00020&0%j\u0002`'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R!\u00105\u001a\b\u0012\u0004\u0012\u0002000/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u0010<\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010A\u001a\u00020=8\u0006\u00a2\u0006\f\n\u0004\b3\u0010>\u001a\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR(\u0010O\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010J8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bL\u0010NR\u0011\u0010R\u001a\u00020P8F\u00a2\u0006\u0006\u001a\u0004\bC\u0010Q\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", "", "", DomainData.DOMAIN_NAME, "", "extOperate", "d", "Landroid/content/Context;", "context", "i", "mode", "y", "bottomHeight", "t", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "background", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "u", "r", "", "isSupportAt", "v", "isGuildMember", ReportConstant.COSTREPORT_PREFIX, "k", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "j", "l", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "a", "Lxk1/d;", "inputWindow", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "attachInfo", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "c", "Lkotlin/Lazy;", "e", "()[Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "actors", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "getDismissListener", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;)V", "dismissListener", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", tl.h.F, "()Lcom/tencent/mobileqq/guild/feed/util/framework/route/a;", "router", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", "getDismissCause", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", "setDismissCause", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;)V", "dismissCause", "Lgl1/b;", "<set-?>", "g", "Lgl1/b;", "()Lgl1/b;", "reporter", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", "<init>", "()V", "InputBarDismissCause", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NativeDetailInputWindowDirector {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private xk1.d<NativeDetailInputWindowAdorn> inputWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b attachInfo = new b(new Bundle());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy actors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d dismissListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.util.framework.route.a router;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private InputBarDismissCause dismissCause;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gl1.b reporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "SWITCH_TO_PAGE", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum InputBarDismissCause {
        UNKNOWN,
        SWITCH_TO_PAGE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\b0\b0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R(\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R-\u0010)\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'0\u00108\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b(\u0010\u0014R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\u0011\u0010/\u001a\u00020-8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010.R\u0011\u00100\u001a\u00020-8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010.R\u0019\u00101\u001a\n \u0011*\u0004\u0018\u00010-0-8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010.R\u0011\u00104\u001a\u0002028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u00103R\u0013\u00105\u001a\u0004\u0018\u00010-8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "", "Landroid/os/Bundle;", "a", "Landroid/os/Bundle;", "c", "()Landroid/os/Bundle;", "extra", "", "b", "Z", "l", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "isInitialized", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", tl.h.F, "()Landroidx/lifecycle/MutableLiveData;", "setInputAtState", "(Landroidx/lifecycle/MutableLiveData;)V", "inputAtState", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setSupportAtState", "isSupportAtState", "e", "k", "setGuildMember", "isGuildMember", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "f", "g", "setInputArgsState", "inputArgsState", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "i", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "j", "o", "originalPic", "", "()Ljava/lang/String;", "guildId", "channelId", "feedId", "", "()I", "businessType", "hint", "<init>", "(Landroid/os/Bundle;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Bundle extra;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isInitialized;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MutableLiveData<Boolean> inputAtState;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MutableLiveData<Boolean> isSupportAtState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MutableLiveData<Boolean> isGuildMember;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MutableLiveData<ShowInputComponentArgs> inputArgsState;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<ArrayList<LocalMediaInfo>> localMediaInfos;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean originalPic;

        public b(@NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.extra = extra;
            this.inputAtState = new MutableLiveData<>(Boolean.FALSE);
            this.isSupportAtState = new MutableLiveData<>();
            this.isGuildMember = new MutableLiveData<>();
            this.inputArgsState = new MutableLiveData<>();
            this.localMediaInfos = new MutableLiveData<>();
        }

        public final int a() {
            return this.extra.getInt("business_type");
        }

        @NotNull
        public final String b() {
            String string = this.extra.getString("channel_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "extra.getString(NativeDe\u2026Constants.CHANNEL_ID, \"\")");
            return string;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Bundle getExtra() {
            return this.extra;
        }

        public final String d() {
            return this.extra.getString("feed_id", "");
        }

        @NotNull
        public final String e() {
            String string = this.extra.getString("guild_id", "");
            Intrinsics.checkNotNullExpressionValue(string, "extra.getString(NativeDe\u2026ilConstants.GUILD_ID, \"\")");
            return string;
        }

        @Nullable
        public final String f() {
            return this.extra.getString("feed_comment_input_bar_hint");
        }

        @NotNull
        public final MutableLiveData<ShowInputComponentArgs> g() {
            return this.inputArgsState;
        }

        @NotNull
        public final MutableLiveData<Boolean> h() {
            return this.inputAtState;
        }

        @NotNull
        public final MutableLiveData<ArrayList<LocalMediaInfo>> i() {
            return this.localMediaInfos;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getOriginalPic() {
            return this.originalPic;
        }

        @NotNull
        public final MutableLiveData<Boolean> k() {
            return this.isGuildMember;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getIsInitialized() {
            return this.isInitialized;
        }

        @NotNull
        public final MutableLiveData<Boolean> m() {
            return this.isSupportAtState;
        }

        public final void n(boolean z16) {
            this.isInitialized = z16;
        }

        public final void o(boolean z16) {
            this.originalPic = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface d {
        void a(@NotNull InputBarDismissCause cause);
    }

    public NativeDetailInputWindowDirector() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a[]>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector$actors$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NativeDetailInputWindowDirector.a[] invoke() {
                NativeDetailInputWindowDirector.b bVar;
                NativeDetailInputWindowDirector.b bVar2;
                NativeDetailInputWindowDirector.b bVar3;
                NativeDetailInputWindowDirector.b bVar4;
                NativeDetailInputWindowDirector.b bVar5;
                NativeDetailInputWindowDirector.b bVar6;
                NativeDetailInputWindowDirector.b bVar7;
                NativeDetailInputWindowDirector.b bVar8;
                NativeDetailInputWindowDirector.b bVar9;
                NativeDetailInputWindowDirector.b bVar10;
                NativeDetailInputWindowDirector.b bVar11;
                bVar = NativeDetailInputWindowDirector.this.attachInfo;
                bVar2 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar3 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar4 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar5 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar6 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar7 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar8 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar9 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar10 = NativeDetailInputWindowDirector.this.attachInfo;
                bVar11 = NativeDetailInputWindowDirector.this.attachInfo;
                return new NativeDetailInputWindowDirector.a[]{new SendButtonActor(bVar), new EditTextInputActor(bVar2), new AtButtonActor(bVar3), new PicButtonActor(bVar4), new j(bVar5), new EmojiPanelCallbackActor(bVar6), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d(bVar7), new SelectPicActor(bVar8), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.f(bVar9), new NewLineCompatActor(bVar10), new SyncToTroopSwitcherActor(bVar11)};
            }
        });
        this.actors = lazy;
        this.router = new InterfaceRouterImpl();
        this.dismissCause = InputBarDismissCause.UNKNOWN;
    }

    private final int d(int extOperate) {
        if (extOperate == 0) {
            return 0;
        }
        if (extOperate == 1) {
            return 2;
        }
        if (extOperate == 2) {
            return 3;
        }
        if (extOperate != 3) {
            return 0;
        }
        return 4;
    }

    private final a[] e() {
        return (a[]) this.actors.getValue();
    }

    private final void n() {
        xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
        xk1.d<NativeDetailInputWindowAdorn> dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
            dVar = null;
        }
        dVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.f
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NativeDetailInputWindowDirector.o(NativeDetailInputWindowDirector.this, dialogInterface);
            }
        });
        xk1.d<NativeDetailInputWindowAdorn> dVar3 = this.inputWindow;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
        } else {
            dVar2 = dVar3;
        }
        dVar2.X().F(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.g
            @Override // java.lang.Runnable
            public final void run() {
                NativeDetailInputWindowDirector.p(NativeDetailInputWindowDirector.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(NativeDetailInputWindowDirector this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (a aVar : this$0.e()) {
            aVar.d();
        }
        QLog.i("NativeDetailCommentWindow", 1, "onDismiss");
        d dVar = this$0.dismissListener;
        if (dVar != null) {
            dVar.a(this$0.dismissCause);
        }
        this$0.dismissCause = InputBarDismissCause.UNKNOWN;
        gl1.b bVar = this$0.reporter;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(NativeDetailInputWindowDirector this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("NativeDetailCommentWindow", 1, "onOtherPageOpen");
        this$0.dismissCause = InputBarDismissCause.SWITCH_TO_PAGE;
    }

    @NotNull
    public final Bundle f() {
        return this.attachInfo.getExtra();
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final gl1.b getReporter() {
        return this.reporter;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.mobileqq.guild.feed.util.framework.route.a getRouter() {
        return this.router;
    }

    public final void i(@NotNull Context context) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.attachInfo.getIsInitialized()) {
            return;
        }
        NativeDetailInputWindowAdorn nativeDetailInputWindowAdorn = new NativeDetailInputWindowAdorn();
        xk1.d<NativeDetailInputWindowAdorn> dVar = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        nativeDetailInputWindowAdorn.r(activity);
        xk1.d<NativeDetailInputWindowAdorn> dVar2 = new xk1.d<>(nativeDetailInputWindowAdorn, this.router, context, R.style.awn);
        dVar2.c0();
        this.inputWindow = dVar2;
        for (a aVar : e()) {
            xk1.d<NativeDetailInputWindowAdorn> dVar3 = this.inputWindow;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar3 = null;
            }
            aVar.e(dVar3);
            this.router.a(aVar.getClass(), aVar);
        }
        n();
        xk1.d<NativeDetailInputWindowAdorn> dVar4 = this.inputWindow;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
        } else {
            dVar = dVar4;
        }
        gl1.b bVar = new gl1.b(dVar.X().v());
        this.router.a(gl1.b.class, bVar);
        this.reporter = bVar;
        this.attachInfo.n(true);
        AtUserHelper.h(this.attachInfo.e(), this.attachInfo.b());
    }

    public final void j(int requestCode, int resultCode, @Nullable Intent data) {
        for (a aVar : e()) {
            aVar.c(requestCode, resultCode, data);
        }
    }

    public final void k() {
        if (this.attachInfo.getIsInitialized()) {
            for (a aVar : e()) {
                aVar.onDestroy();
            }
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.onDestroy();
        }
        this.attachInfo.n(false);
        AtUserHelper.b();
    }

    public final void l() {
        for (a aVar : e()) {
            aVar.f();
        }
    }

    public final void m(@Nullable d dVar) {
        this.dismissListener = dVar;
    }

    public final void q() {
        if (this.attachInfo.getIsInitialized()) {
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.X().v().a().setText("");
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void r() {
        xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
        if (dVar == null) {
            return;
        }
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
            dVar = null;
        }
        dVar.dismiss();
    }

    public final void s(boolean isGuildMember) {
        this.attachInfo.k().setValue(Boolean.valueOf(isGuildMember));
    }

    public final void t(int bottomHeight) {
        if (this.attachInfo.getIsInitialized()) {
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.X().G(bottomHeight);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void u(@NotNull ShowInputComponentArgs inputArgs) {
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        if (this.attachInfo.getIsInitialized()) {
            this.attachInfo.g().setValue(inputArgs);
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.n0(d(inputArgs.getExtOperate()));
            gl1.b bVar = this.reporter;
            if (bVar != null) {
                bVar.f(inputArgs.getInvokeFrom());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void v(boolean isSupportAt) {
        if (this.attachInfo.getIsInitialized()) {
            this.attachInfo.m().setValue(Boolean.valueOf(isSupportAt));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void w(@Nullable Bitmap bitmap) {
        if (this.attachInfo.getIsInitialized()) {
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.X().K(bitmap);
            this.dismissCause = InputBarDismissCause.UNKNOWN;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void x(@NotNull Drawable background) {
        Intrinsics.checkNotNullParameter(background, "background");
        if (this.attachInfo.getIsInitialized()) {
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            xk1.d<NativeDetailInputWindowAdorn> dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
                dVar = null;
            }
            dVar.X().v().getMRv().setBackground(background);
            xk1.d<NativeDetailInputWindowAdorn> dVar3 = this.inputWindow;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
            } else {
                dVar2 = dVar3;
            }
            dVar2.X().v().getMRv().getBackground().setAlpha(0);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void y(int mode) {
        xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
            dVar = null;
        }
        Window window = dVar.getWindow();
        if (window != null) {
            window.setSoftInputMode(mode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004H\u0017J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016R\u001a\u0010\u0015\u001a\u00020\u00118\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R,\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00048\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "", "e", "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "c", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "a", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "attachInfo", "Lxk1/d;", "b", "()Lxk1/d;", "g", "(Lxk1/d;)V", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b attachInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        protected xk1.d<NativeDetailInputWindowAdorn> inputWindow;

        public a(@NotNull b attachInfo) {
            Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
            this.attachInfo = attachInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        /* renamed from: a, reason: from getter */
        public final b getAttachInfo() {
            return this.attachInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        public final xk1.d<NativeDetailInputWindowAdorn> b() {
            xk1.d<NativeDetailInputWindowAdorn> dVar = this.inputWindow;
            if (dVar != null) {
                return dVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("inputWindow");
            return null;
        }

        @CallSuper
        public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
            Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
            g(inputWindow);
        }

        protected final void g(@NotNull xk1.d<NativeDetailInputWindowAdorn> dVar) {
            Intrinsics.checkNotNullParameter(dVar, "<set-?>");
            this.inputWindow = dVar;
        }

        public void d() {
        }

        public void f() {
        }

        public void onDestroy() {
        }

        public void c(int requestCode, int resultCode, @Nullable Intent data) {
        }
    }
}
