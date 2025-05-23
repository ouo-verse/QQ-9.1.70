package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryPageCloseEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001AB\u0013\u0012\n\u0010=\u001a\u00060;j\u0002`<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u001a\u0010\u001b\u001a\u00020\u00052\u0010\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00180\u0017j\u0002`\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\"\u0010\u001e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\"\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020 J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&`'H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u000f048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/SelectPicActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "u", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "args", "", "p", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "r", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", DomainData.DOMAIN_NAME, "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "c", "mediaInfo", "", "originalPic", ReportConstant.COSTREPORT_PREFIX, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mMediaInfo", "", tl.h.F, UserInfo.SEX_FEMALE, "defaultImageSize", "i", "Ljava/lang/String;", "curSelectedPicKey", "Z", "clickedForPreview", "Landroidx/lifecycle/Observer;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/Observer;", "inputArgsObserver", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SelectPicActor extends NativeDetailInputWindowDirector.a implements SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final a D = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Observer<ShowInputComponentArgs> inputArgsObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo mMediaInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float defaultImageSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curSelectedPicKey;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean clickedForPreview;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/SelectPicActor$a;", "", "", "CORNER_RADIUS_DP", "I", "", "DELAY_SHOW_AFTER_AT_DISMISS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220495a;

        static {
            int[] iArr = new int[InputFunctionType.values().length];
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_COMMENT_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220495a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectPicActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.defaultImageSize = 80.0f;
        this.curSelectedPicKey = "";
        this.inputArgsObserver = new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectPicActor.t(SelectPicActor.this, (ShowInputComponentArgs) obj);
            }
        };
    }

    private final void m() {
        if (b().getIsInitialized() && !b().N()) {
            b().n0(0);
        } else {
            QLog.w(q(), 1, "checkStartInput|invalid state");
        }
    }

    private final GuildFeedGalleryInitBean n() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setFeedId(getAttachInfo().d());
        guildFeedGalleryInitBean.setGuildId(getAttachInfo().e());
        guildFeedGalleryInitBean.setChannelId(getAttachInfo().b());
        return guildFeedGalleryInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        b().X().v().getPicContainer().setVisibility(8);
        getAttachInfo().i().setValue(null);
        SendButtonActor sendButtonActor = (SendButtonActor) b().getRouter().b(SendButtonActor.class);
        if (sendButtonActor != null) {
            sendButtonActor.n();
        }
        NewLineCompatActor newLineCompatActor = (NewLineCompatActor) b().getRouter().b(NewLineCompatActor.class);
        if (newLineCompatActor != null) {
            newLineCompatActor.s();
        }
    }

    private final String p(ShowInputComponentArgs args) {
        InputFunctionType inputFunctionType;
        int i3;
        ReplyCommentArgs replyCommentArgs;
        if (args != null) {
            inputFunctionType = args.getInputFunctionType();
        } else {
            inputFunctionType = null;
        }
        if (inputFunctionType == null) {
            i3 = -1;
        } else {
            i3 = b.f220495a[inputFunctionType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2 || (replyCommentArgs = args.getReplyCommentArgs()) == null) {
                return null;
            }
            return replyCommentArgs.e();
        }
        return getAttachInfo().d();
    }

    private final String q() {
        return "InputSelectPicActor";
    }

    private final LocalMediaInfo r(Intent data) {
        if (data == null) {
            return null;
        }
        List<Object> mediaInfoList = ((IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class)).getMediaInfoList(data);
        if (bl.b(mediaInfoList)) {
            return null;
        }
        Object obj = mediaInfoList.get(0);
        if (!(obj instanceof LocalMediaInfo)) {
            return null;
        }
        return (LocalMediaInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(SelectPicActor this$0, ShowInputComponentArgs showInputComponentArgs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clickedForPreview = false;
        if (showInputComponentArgs == null) {
            return;
        }
        QLog.i("InputSelectPicActor", 1, "inputArgsObserver curSelectedPicKey=" + this$0.curSelectedPicKey + " getDraftKey=" + this$0.p(showInputComponentArgs));
        if (!Intrinsics.areEqual(this$0.curSelectedPicKey, this$0.p(showInputComponentArgs))) {
            this$0.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.clickedForPreview = true;
        Runnable onOtherPageOpen = b().X().getOnOtherPageOpen();
        if (onOtherPageOpen != null) {
            onOtherPageOpen.run();
        }
        GuildFeedLauncher.I(b().getContext(), n(), this.mMediaInfo, b().X().v().getPicIv());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(SelectPicActor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    private final void w(int requestCode, int resultCode, Intent data) {
        QLog.d("InputSelectPicActor", 4, "requestCode = " + requestCode + ",  resultCode = " + resultCode);
        if (requestCode == 10014) {
            boolean z16 = false;
            if (data != null) {
                z16 = data.getBooleanExtra(PeakConstants.GUILD_ALBUM_QUALITY, false);
            }
            LocalMediaInfo r16 = r(data);
            if (r16 != null) {
                s(r16, z16);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.o
                @Override // java.lang.Runnable
                public final void run() {
                    SelectPicActor.x(SelectPicActor.this);
                }
            }, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(SelectPicActor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void c(int requestCode, int resultCode, @Nullable Intent data) {
        w(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        inputWindow.X().v().getPicContainer().setVisibility(8);
        jt1.b.b(inputWindow.X().v().getPicDelete(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SelectPicActor$onInputWindowInitialized$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SelectPicActor.this.o();
            }
        });
        jt1.b.b(inputWindow.X().v().getPicIv(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SelectPicActor$onInputWindowInitialized$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SelectPicActor.this.u();
            }
        });
        inputWindow.X().v().getPicIv().setCornerRadiusAndMode(wn0.a.f445842a.b(4), 1);
        ImageViewPorterDuffUtils.f235385a.c(inputWindow.X().v().getPicIv());
        SimpleEventBus.getInstance().registerReceiver(this);
        getAttachInfo().g().observeForever(this.inputArgsObserver);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void f() {
        this.mMediaInfo = null;
        getAttachInfo().o(false);
        getAttachInfo().i().setValue(null);
        b().X().v().getPicContainer().setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedGalleryPageCloseEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        getAttachInfo().g().removeObserver(this.inputArgsObserver);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.i("InputSelectPicActor", 2, "onReceiveEvent clickedForPreview=" + this.clickedForPreview);
        if ((event instanceof GuildFeedGalleryPageCloseEvent) && Intrinsics.areEqual(((GuildFeedGalleryPageCloseEvent) event).getFeedId(), getAttachInfo().d()) && this.clickedForPreview) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.n
                @Override // java.lang.Runnable
                public final void run() {
                    SelectPicActor.v(SelectPicActor.this);
                }
            }, 10L);
            this.clickedForPreview = false;
        }
    }

    public final void s(@Nullable LocalMediaInfo mediaInfo, boolean originalPic) {
        String trimIndent;
        if (mediaInfo == null) {
            return;
        }
        this.curSelectedPicKey = p(getAttachInfo().g().getValue());
        this.mMediaInfo = mediaInfo;
        b().X().v().getPicContainer().setVisibility(0);
        LocalMediaInfo localMediaInfo = this.mMediaInfo;
        if (localMediaInfo != null) {
            ArrayList<LocalMediaInfo> arrayList = new ArrayList<>();
            arrayList.add(localMediaInfo);
            getAttachInfo().i().setValue(arrayList);
            getAttachInfo().o(originalPic);
        }
        int a16 = com.tencent.mobileqq.guild.feed.util.e.a(b().getContext(), this.defaultImageSize);
        LocalMediaInfo localMediaInfo2 = this.mMediaInfo;
        Intrinsics.checkNotNull(localMediaInfo2);
        String str = localMediaInfo2.path;
        QLog.i("InputSelectPicActor", 4, "topContainerPicPath: " + str);
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            com.tencent.mobileqq.guild.picload.e.a().f(new Option().setTargetView(b().X().v().getPicIv()).setUrl(str).setRequestWidth(a16).setRequestHeight(a16), null);
            LocalMediaInfo localMediaInfo3 = this.mMediaInfo;
            Intrinsics.checkNotNull(localMediaInfo3);
            String str3 = localMediaInfo3.path;
            LocalMediaInfo localMediaInfo4 = this.mMediaInfo;
            if (localMediaInfo4 != null) {
                str2 = localMediaInfo4.thumbnailPath;
            }
            trimIndent = StringsKt__IndentKt.trimIndent("handleSelectPhotosResult" + str3 + "\n            " + str2 + "\n            ");
            QLog.i("InputSelectPicActor", 1, trimIndent);
            SendButtonActor sendButtonActor = (SendButtonActor) b().getRouter().b(SendButtonActor.class);
            if (sendButtonActor != null) {
                sendButtonActor.n();
            }
            NewLineCompatActor newLineCompatActor = (NewLineCompatActor) b().getRouter().b(NewLineCompatActor.class);
            if (newLineCompatActor != null) {
                newLineCompatActor.s();
            }
            EditTextInputActor editTextInputActor = (EditTextInputActor) b().getRouter().b(EditTextInputActor.class);
            if (editTextInputActor != null) {
                editTextInputActor.o();
            }
        }
    }
}
