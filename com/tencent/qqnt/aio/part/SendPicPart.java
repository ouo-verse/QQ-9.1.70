package com.tencent.qqnt.aio.part;

import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.aio.data.AIOContact;
import com.tencent.biz.richframework.part.Part;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.AIOPhotoPanelEvent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.album.ext.WrapLocalMediaInfoKt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.ab;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.util.AutoSaveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import dov.com.qq.im.ae.current.SessionWrap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/part/SendPicPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Intent;", "intent", "", "G9", "E9", "K9", "Lcom/tencent/aio/data/AIOContact;", "aioContact", "B9", "Ldov/com/qq/im/ae/current/SessionWrap;", "sessionWrap", "C9", "", "filePath", "thumbPath", "", "isPhotoPanelEdit", CustomImageProps.QUALITY, "I9", "newIntent", "onNewIntent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/qqnt/aio/a;", "d", "Lcom/tencent/qqnt/aio/a;", "D9", "()Lcom/tencent/qqnt/aio/a;", "aioContext", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "e", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "sendByFile", "<init>", "(Lcom/tencent/qqnt/aio/a;)V", "f", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class SendPicPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.aio.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SendByFile sendByFile;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/part/SendPicPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.part.SendPicPart$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/part/SendPicPart$b", "Lcom/tencent/mobileqq/album/ext/b;", "", "Lcom/tencent/mobileqq/album/media/c;", ForwardMiniChooseFriendOption.RESULT_LIST, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mobileqq.album.ext.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlbumResult f351755a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SendPicPart f351756b;

        b(AlbumResult albumResult, SendPicPart sendPicPart) {
            this.f351755a = albumResult;
            this.f351756b = sendPicPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) albumResult, (Object) sendPicPart);
            }
        }

        @Override // com.tencent.mobileqq.album.ext.b
        public void a(@NotNull List<com.tencent.mobileqq.album.media.c> results) {
            List list;
            List list2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) results);
                return;
            }
            Intrinsics.checkNotNullParameter(results, "results");
            if (!TextUtils.isEmpty(this.f351755a.a())) {
                QLog.d("SendPicPart", 1, "handleAlbumResult real send MixEvent. list:" + results.size());
                com.tencent.qqnt.aio.a D9 = this.f351756b.D9();
                list2 = CollectionsKt___CollectionsKt.toList(results);
                boolean g16 = this.f351755a.g();
                String a16 = this.f351755a.a();
                Intrinsics.checkNotNull(a16);
                D9.b(new AIOMsgSendEvent.SendAlbumMixEvent(list2, g16, a16));
                return;
            }
            if (!results.isEmpty()) {
                QLog.d("SendPicPart", 1, "handleAlbumResult real send mediaEvent. list:" + results.size());
                com.tencent.qqnt.aio.a D92 = this.f351756b.D9();
                list = CollectionsKt___CollectionsKt.toList(results);
                D92.b(new AIOMsgSendEvent.SendAlbumMediaEvent(list, this.f351755a.g(), this.f351755a.f()));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SendPicPart(@NotNull com.tencent.qqnt.aio.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
        } else {
            this.aioContext = aioContext;
            this.sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
        }
    }

    private final void B9(AIOContact aioContact, final Intent intent) {
        if (intent.getBooleanExtra(PeakConstants.USE_NEW_ALBUM, false)) {
            SessionWrap sessionWrap = (SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
            QLog.d("SendPicPart", 2, "checkAIOContext intent sessionWrap:" + sessionWrap + " aioContact:" + aioContact + " from album");
            if (sessionWrap != null) {
                C9(aioContact, intent, sessionWrap);
                return;
            }
            return;
        }
        final String stringExtra = intent.getStringExtra("uin");
        final int intExtra = intent.getIntExtra("uintype", -1);
        int c16 = com.tencent.nt.adapter.session.c.c(aioContact.e());
        QLog.d("SendPicPart", 2, "checkAIOContext intentUin:" + stringExtra + " intentType:" + intExtra + " aioUid:" + aioContact.j() + " uinType:" + c16 + " chatType:" + aioContact.e() + " not from album");
        if (8 == aioContact.e()) {
            K9(intent);
            QLog.d("SendPicPart", 2, "checkAIOContext Dataline Photograph");
        } else {
            com.tencent.nt.adapter.session.c.h(aioContact.j(), aioContact.e(), new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>(stringExtra, intExtra, this, intent) { // from class: com.tencent.qqnt.aio.part.SendPicPart$checkAIOContext$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Intent $intent;
                final /* synthetic */ int $intentType;
                final /* synthetic */ String $intentUin;
                final /* synthetic */ SendPicPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$intentUin = stringExtra;
                    this.$intentType = intExtra;
                    this.this$0 = this;
                    this.$intent = intent;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, stringExtra, Integer.valueOf(intExtra), this, intent);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
                    invoke(bool.booleanValue(), fVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable com.tencent.nt.adapter.session.f fVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), fVar);
                        return;
                    }
                    if (z16 && fVar != null) {
                        String a16 = fVar.a();
                        int b16 = fVar.b();
                        if (Intrinsics.areEqual(a16, this.$intentUin) && this.$intentType == b16) {
                            this.this$0.K9(this.$intent);
                            return;
                        }
                        QLog.e("SendPicPart", 1, "checkAIOContext uid2uin aioSession:" + fVar + " not match");
                        return;
                    }
                    QLog.e("SendPicPart", 1, "checkAIOContext uid2uin Failed");
                }
            });
        }
    }

    private final void C9(AIOContact aioContact, final Intent intent, final SessionWrap sessionWrap) {
        if (Intrinsics.areEqual(aioContact.j(), sessionWrap.f394452m) && aioContact.e() == sessionWrap.f394451i) {
            K9(intent);
        } else {
            com.tencent.nt.adapter.session.c.h(aioContact.j(), aioContact.e(), new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>(this, intent) { // from class: com.tencent.qqnt.aio.part.SendPicPart$checkFromAlbum$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Intent $intent;
                final /* synthetic */ SendPicPart this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                    this.$intent = intent;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, SessionWrap.this, this, intent);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.f fVar) {
                    invoke(bool.booleanValue(), fVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @Nullable com.tencent.nt.adapter.session.f fVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), fVar);
                        return;
                    }
                    if (z16 && fVar != null) {
                        if (Intrinsics.areEqual(fVar.a(), SessionWrap.this.f394447d) && fVar.b() == SessionWrap.this.f394449f) {
                            this.this$0.K9(this.$intent);
                            return;
                        }
                        if (Intrinsics.areEqual(fVar.a(), SessionWrap.this.f394447d)) {
                            this.this$0.K9(this.$intent);
                            return;
                        }
                        QLog.e("SendPicPart", 1, "checkFromAlbum uid2uin aioSession:" + fVar + " not match");
                        return;
                    }
                    QLog.e("SendPicPart", 1, "checkFromAlbum uid2uin Failed");
                }
            });
        }
    }

    private final void E9(final Intent intent) {
        Integer num;
        Boolean bool;
        List<LocalMediaInfo> e16;
        String joinToString$default;
        int collectionSizeOrDefault;
        boolean z16;
        boolean z17;
        List<LocalMediaInfo> e17;
        intent.getStringExtra("key_peerId");
        intent.getIntExtra("key_chat_type", 0);
        AlbumResult albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
        if (albumResult != null && (e17 = albumResult.e()) != null) {
            num = Integer.valueOf(e17.size());
        } else {
            num = null;
        }
        if (albumResult != null) {
            bool = Boolean.valueOf(albumResult.b());
        } else {
            bool = null;
        }
        QLog.d("SendPicPart", 1, "handleAlbumResult selectList:" + num + " needSend:" + bool);
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            if (!albumResult.b()) {
                this.aioContext.b(PhotoPanelEvent.OnAlbumResult.f188680d);
                QLog.d("SendPicPart", 1, "no need send");
                return;
            }
            intent.removeExtra("ALBUM_RESULT");
            this.aioContext.b(AIOPhotoPanelEvent.PhotoEditSend.f188481d);
            if (8 == this.aioContext.a().e()) {
                List<LocalMediaInfo> list = e16;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (true) {
                    String str = "";
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    String path = ((LocalMediaInfo) next).getPath();
                    if (path != null) {
                        str = path;
                    }
                    if (com.tencent.qqnt.aio.element.file.util.a.e(str) == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() >= 4) {
                    ArrayList<LocalMediaInfo> arrayList2 = new ArrayList();
                    for (Object obj : list) {
                        String path2 = ((LocalMediaInfo) obj).getPath();
                        if (path2 == null) {
                            path2 = "";
                        }
                        if (com.tencent.qqnt.aio.element.file.util.a.e(path2) != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            arrayList2.add(obj);
                        }
                    }
                    for (LocalMediaInfo localMediaInfo : arrayList2) {
                        QLog.d("SendPicPart", 1, "handleAlbumResult myComputerSendFileFromPhoto: " + localMediaInfo.getPath());
                        IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class);
                        String j3 = this.aioContext.a().j();
                        String path3 = localMediaInfo.getPath();
                        Intrinsics.checkNotNull(path3);
                        iMyComputerHelpApi.myComputerSendFileFromPhoto(j3, path3);
                    }
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, SendPicPart$handleAlbumResult$2.INSTANCE, 30, null);
                    QLog.d("SendPicPart", 1, "handleAlbumResult myComputerSendMultiFileFromPhoto: " + joinToString$default);
                    IMyComputerHelpApi iMyComputerHelpApi2 = (IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class);
                    String j16 = this.aioContext.a().j();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        String path4 = ((LocalMediaInfo) it5.next()).getPath();
                        Intrinsics.checkNotNull(path4);
                        arrayList3.add(path4);
                    }
                    iMyComputerHelpApi2.myComputerSendMultiFileFromPhoto(j16, arrayList3);
                } else {
                    for (LocalMediaInfo localMediaInfo2 : e16) {
                        QLog.d("SendPicPart", 1, "handleAlbumResult myComputerSendFileFromPhoto: " + localMediaInfo2.getPath());
                        IMyComputerHelpApi iMyComputerHelpApi3 = (IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class);
                        String j17 = this.aioContext.a().j();
                        String path5 = localMediaInfo2.getPath();
                        Intrinsics.checkNotNull(path5);
                        iMyComputerHelpApi3.myComputerSendFileFromPhoto(j17, path5);
                    }
                }
            } else {
                ArrayList arrayList4 = new ArrayList();
                for (final LocalMediaInfo localMediaInfo3 : e16) {
                    if (ab.a(this.aioContext.a().e(), localMediaInfo3, albumResult.g())) {
                        ox3.a.a("SendPicPart", new Function0<String>(this) { // from class: com.tencent.qqnt.aio.part.SendPicPart$handleAlbumResult$4
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ SendPicPart this$0;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.this$0 = this;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this, (Object) this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                                }
                                return "handleAlbumResult transFileToSend: " + LocalMediaInfo.this.getPath() + ", chatType: " + this.this$0.D9().a().e();
                            }
                        });
                        if (this.aioContext.a().e() == 2) {
                            com.tencent.nt.adapter.session.c.h(this.aioContext.a().j(), this.aioContext.a().e(), new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>(localMediaInfo3, intent) { // from class: com.tencent.qqnt.aio.part.SendPicPart$handleAlbumResult$5
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ Intent $intent;
                                final /* synthetic */ LocalMediaInfo $mediaInfo;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                    this.$mediaInfo = localMediaInfo3;
                                    this.$intent = intent;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, SendPicPart.this, localMediaInfo3, intent);
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2, com.tencent.nt.adapter.session.f fVar) {
                                    invoke(bool2.booleanValue(), fVar);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z18, @Nullable com.tencent.nt.adapter.session.f fVar) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z18), fVar);
                                        return;
                                    }
                                    if (z18 && fVar != null) {
                                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                                        QQAppInterface qQAppInterface2 = qQAppInterface != null ? qQAppInterface : null;
                                        if (qQAppInterface2 == null) {
                                            QLog.e("SendPicPart", 1, "handleAlbumResult appInterface is null");
                                            com.tencent.qqnt.aio.a D9 = SendPicPart.this.D9();
                                            String path6 = this.$mediaInfo.getPath();
                                            Intrinsics.checkNotNull(path6);
                                            D9.b(new AIOMsgSendEvent.FileSendEvent(path6));
                                            return;
                                        }
                                        qQAppInterface2.getFileManagerEngine().K0(this.$mediaInfo.getPath(), fVar.a(), 0L, 0, this.$intent.getExtras());
                                        return;
                                    }
                                    QLog.e("SendPicPart", 1, "handleAlbumResult uid2uin Failed");
                                    com.tencent.qqnt.aio.a D92 = SendPicPart.this.D9();
                                    String path7 = this.$mediaInfo.getPath();
                                    Intrinsics.checkNotNull(path7);
                                    D92.b(new AIOMsgSendEvent.FileSendEvent(path7));
                                }
                            });
                        } else {
                            com.tencent.qqnt.aio.a aVar = this.aioContext;
                            String path6 = localMediaInfo3.getPath();
                            Intrinsics.checkNotNull(path6);
                            aVar.b(new AIOMsgSendEvent.FileSendEvent(path6));
                        }
                    } else {
                        arrayList4.add(WrapLocalMediaInfoKt.j(localMediaInfo3));
                    }
                }
                WrapLocalMediaInfoKt.g(arrayList4, new b(albumResult, this));
            }
            this.aioContext.b(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("SendPicPart", false, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(SendPicPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PreferenceManager.getDefaultSharedPreferences(this$0.getContext()).edit().remove(AppConstants.Preferences.CAMERA_PHOTO_PATH).commit();
    }

    private final void G9(Intent intent) {
        if (intent == null) {
            QLog.e("SendPicPart", 1, "onShow: intent == null");
            return;
        }
        if (intent.getIntExtra("uintype", 0) == 10014) {
            QLog.e("SendPicPart", 1, "guild return");
        } else {
            if (intent.hasExtra("ALBUM_RESULT")) {
                E9(intent);
                return;
            }
            final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            B9(this.aioContext.a(), intent);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.part.m
                @Override // java.lang.Runnable
                public final void run() {
                    SendPicPart.H9(stringArrayListExtra);
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(ArrayList arrayList) {
        AutoSaveUtils.e(true, arrayList);
    }

    private final void I9(String filePath, String thumbPath, boolean isPhotoPanelEdit, boolean quality) {
        boolean z16;
        boolean contains$default;
        boolean contains$default2;
        int i3;
        List listOf;
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(filePath));
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) mimeTypeFromExtension, (CharSequence) "video", false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) mimeTypeFromExtension, (CharSequence) "image", false, 2, (Object) null);
                if (contains$default2) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
            } else {
                i3 = 1;
            }
            QLog.d("SendPicPart", 2, "sendMedia: filepath:" + filePath + " mediaType:" + i3 + " isPhotoPanelEdit:" + isPhotoPanelEdit + " quality:" + quality);
            if (this.aioContext.a().e() == 8) {
                QLog.d("SendPicPart", 1, "sendMedia: filepath:" + filePath + " mediaType:" + i3 + " isPhotoPanelEdit:" + isPhotoPanelEdit + " quality:" + quality);
                ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).myComputerSendFileFromPhoto(this.aioContext.a().j(), filePath);
            } else {
                com.tencent.qqnt.aio.a aVar = this.aioContext;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.mobileqq.album.media.c(null, filePath, i3, null, thumbPath, null, 40, null));
                aVar.b(new AIOMsgSendEvent.MediaSendEvent(listOf, quality, false, true, 4, null));
            }
            if (isPhotoPanelEdit) {
                this.aioContext.b(AIOPhotoPanelEvent.PhotoEditSend.f188481d);
                return;
            }
            return;
        }
        QLog.e("SendPicPart", 1, "send path: " + filePath + " illegal");
    }

    static /* synthetic */ void J9(SendPicPart sendPicPart, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        sendPicPart.I9(str, str2, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(Intent intent) {
        boolean z16;
        boolean z17;
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.SEND_FLAG, false);
        boolean z18 = true;
        QLog.i("SendPicPart", 1, "trySendMedia isPhotoPlusEditSend = " + booleanExtra);
        boolean booleanExtra2 = intent.getBooleanExtra("key_is_scale_chat", false);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        String str = null;
        if (stringArrayListExtra != null) {
            Iterator<T> it = stringArrayListExtra.iterator();
            while (it.hasNext()) {
                QLog.d("SendPicPart", 1, "path: " + ((String) it.next()));
            }
        } else {
            stringArrayListExtra = null;
        }
        if (stringArrayListExtra != null && stringArrayListExtra.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = intent.getStringExtra(PeakConstants.VIDEO_THUMBNAIL_PATH);
        }
        boolean booleanExtra3 = intent.getBooleanExtra(PeakConstants.USE_NEW_ALBUM, false);
        if (intent.getBooleanExtra(PeakConstants.PANEL_VIDEO_EDIT_SEND, false)) {
            intent.removeExtra(PeakConstants.PANEL_VIDEO_EDIT_SEND);
            if (booleanExtra3) {
                this.aioContext.b(AIOPhotoPanelEvent.PhotoEditSend.f188481d);
            }
        }
        if (intent.getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 2) == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (booleanExtra) {
            if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
                z18 = false;
            }
            if (!z18) {
                intent.removeExtra(PeakConstants.SEND_FLAG);
                intent.putExtra("KEY_OPEN_MINI_CHAT", booleanExtra2);
                String str2 = stringArrayListExtra.get(0);
                Intrinsics.checkNotNullExpressionValue(str2, "path[0]");
                I9(str2, str, booleanExtra3, z17);
            }
        }
    }

    @NotNull
    public final com.tencent.qqnt.aio.a D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioContext;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (!((ICaptureUtil) QRoute.api(ICaptureUtil.class)).getFreesiaSupportCapture() && resultCode == -1 && requestCode == 17001) {
            QLog.d("SendPicPart", 1, "UPLOAD_SYS_CAM_NEW_REQUEST");
            String string = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(AppConstants.Preferences.CAMERA_PHOTO_PATH, "");
            if (string == null) {
                str = "";
            } else {
                str = string;
            }
            if (str.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                J9(this, str, null, false, false, 8, null);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.part.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        SendPicPart.F9(SendPicPart.this);
                    }
                }, 16, null, false);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@Nullable Intent newIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newIntent);
        } else {
            QLog.d("SendPicPart", 1, "onNewIntent");
            G9(newIntent);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else if (activity == null) {
            QLog.d("SendPicPart", 1, "onPartResume but activity is null");
        } else {
            QLog.d("SendPicPart", 1, "onPartResume");
            G9(activity.getIntent());
        }
    }
}
