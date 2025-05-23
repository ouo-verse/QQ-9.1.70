package com.tencent.mobileqq.wink.editor.tts.source;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioInfo;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import com.tencent.mobileqq.wink.editor.tts.source.a;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001f\u0010\r\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJR\u0010\u0018\u001a\u00020\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000426\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\u0002J*\u0010\u001c\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u001b\u0010\u001e\u001a\u00020\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ+\u0010\"\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020!\u00a2\u0006\u0004\b\"\u0010#J5\u0010&\u001a\u00020\u00162\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010 \u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020!\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010+\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)J\u0016\u0010.\u001a\u00020\u00162\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u0019J\u0018\u0010/\u001a\u0004\u0018\u00010)2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0016J\u0010\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004R\u001c\u00106\u001a\n 3*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/tts/source/TTSInterfaceDataSource;", "", "", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "", "texts", "o", "path", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", QQPermissionConstants.Permission.AUIDO_GROUP, "g", "([Ljava/lang/Boolean;)Z", "url", "localPath", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "code", "", "callback", "j", "Lcom/tencent/mobileqq/wink/editor/tts/source/a$a;", "type", "", ReportConstant.COSTREPORT_PREFIX, "encoding", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;)Ljava/lang/String;", "ttsType", "Lcom/tencent/mobileqq/wink/editor/tts/source/a;", "u", "([Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/tts/source/a;)V", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSExtraConfig;", "extraConfig", "v", "([Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/tts/source/TTSExtraConfig;Lcom/tencent/mobileqq/wink/editor/tts/source/a;)V", "text", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioItem;", "audioItem", "f", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSAudioInfo;", "audioInfo", "l", h.F, "i", "md5", "r", "kotlin.jvm.PlatformType", "a", "Ljava/lang/String;", "cacheFilePath", "", "b", "Ljava/util/Map;", "audioCacheMap", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSInterfaceServiceHandler;", "c", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/wink/editor/tts/source/TTSInterfaceServiceHandler;", "dataServiceHandler", "<init>", "()V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TTSInterfaceDataSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String cacheFilePath = u53.a.f438364e;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, TTSAudioItem> audioCacheMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dataServiceHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/tts/source/TTSInterfaceDataSource$b", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Integer, Unit> f322584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f322585e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super Integer, Unit> function2, String str) {
            this.f322584d = function2;
            this.f322585e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@Nullable NetResp resp) {
            boolean z16;
            if (resp == null) {
                this.f322584d.invoke(Boolean.FALSE, Integer.valueOf(QAdConfigDefine$APPID.QQLIVE));
                return;
            }
            if (resp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            w53.b.a("TTSInterfaceDataSource", "download onResp: " + z16 + ", " + this.f322585e);
            this.f322584d.invoke(Boolean.valueOf(z16), Integer.valueOf(resp.mResult));
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
            Intrinsics.checkNotNullParameter(req, "req");
        }
    }

    public TTSInterfaceDataSource() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TTSInterfaceServiceHandler>() { // from class: com.tencent.mobileqq.wink.editor.tts.source.TTSInterfaceDataSource$dataServiceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TTSInterfaceServiceHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(TTSInterfaceServiceHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.tts.source.TTSInterfaceServiceHandler");
                return (TTSInterfaceServiceHandler) businessHandler;
            }
        });
        this.dataServiceHandler = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(Boolean[] record) {
        for (Boolean bool : record) {
            if (bool == null) {
                return false;
            }
        }
        return true;
    }

    private final void j(final String url, final String localPath, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.tts.source.d
            @Override // java.lang.Runnable
            public final void run() {
                TTSInterfaceDataSource.k(Function2.this, url, localPath);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function2 callback, String str, String localPath) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(localPath, "$localPath");
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = localPath;
        httpNetReq.mCallback = new b(callback, str);
        try {
            ((IHttpEngineService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c("TTSInterfaceDataSource", "[downloadTTS], error=" + e16);
            callback.invoke(Boolean.FALSE, 1000007);
        }
    }

    private final String m(Integer encoding) {
        if (encoding == null) {
            return DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
        }
        encoding.intValue();
        return DefaultHlsExtractorFactory.MP3_FILE_EXTENSION;
    }

    static /* synthetic */ String n(TTSInterfaceDataSource tTSInterfaceDataSource, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = 0;
        }
        return tTSInterfaceDataSource.m(num);
    }

    private final String o(int templateType, String texts) {
        return templateType + "_" + texts.hashCode();
    }

    private final TTSInterfaceServiceHandler p() {
        return (TTSInterfaceServiceHandler) this.dataServiceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long q(String path) {
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            reportMediaPlayer.setDataSource(path);
            reportMediaPlayer.prepare();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        long duration = reportMediaPlayer.getDuration() * 1000;
        reportMediaPlayer.release();
        return duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(final a.InterfaceC9047a callback, final int type, final boolean[] success, final int code) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.tts.source.c
            @Override // java.lang.Runnable
            public final void run() {
                TTSInterfaceDataSource.t(a.InterfaceC9047a.this, type, success, code);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(a.InterfaceC9047a interfaceC9047a, int i3, boolean[] success, int i16) {
        Intrinsics.checkNotNullParameter(success, "$success");
        if (interfaceC9047a != null) {
            interfaceC9047a.a(i3, success, i16);
        }
    }

    public final void f(int templateType, @NotNull String text, @NotNull TTSAudioItem audioItem) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(audioItem, "audioItem");
        if (!TextUtils.isEmpty(text) && templateType > 0) {
            this.audioCacheMap.put(o(templateType, text), audioItem);
        }
    }

    @Nullable
    public final TTSAudioItem h(int templateType, @NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return this.audioCacheMap.get(o(templateType, text));
    }

    public final void i() {
        this.audioCacheMap.clear();
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [T, boolean[]] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, java.lang.Boolean[]] */
    public final void l(@NotNull final TTSAudioInfo audioInfo, @NotNull final a.InterfaceC9047a callback) {
        boolean z16;
        int i3;
        int i16;
        String str;
        Ref.ObjectRef objectRef;
        String str2 = "audioInfo";
        Intrinsics.checkNotNullParameter(audioInfo, "audioInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (audioInfo.getAudioItems() != null) {
            TTSAudioItem[] audioItems = audioInfo.getAudioItems();
            Intrinsics.checkNotNullExpressionValue(audioItems, "audioInfo.audioItems");
            if (audioItems.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int length = audioInfo.getAudioItems().length;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = new Boolean[length];
                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = new boolean[length];
                TTSAudioItem[] audioItems2 = audioInfo.getAudioItems();
                Intrinsics.checkNotNullExpressionValue(audioItems2, "audioInfo.audioItems");
                int length2 = audioItems2.length;
                final int i17 = 0;
                int i18 = 0;
                while (i18 < length2) {
                    final TTSAudioItem tTSAudioItem = audioItems2[i18];
                    int i19 = i17 + 1;
                    AudioInfo audioInfo2 = tTSAudioItem.getAudioInfo();
                    if (audioInfo2 != null) {
                        Intrinsics.checkNotNullExpressionValue(audioInfo2, str2);
                        final String r16 = r(audioInfo2.MD5);
                        w53.b.a("TTSInterfaceDataSource", "download onResp: " + audioInfo.getTemplateType());
                        str = str2;
                        final Ref.ObjectRef objectRef4 = objectRef2;
                        objectRef = objectRef2;
                        i3 = i18;
                        i16 = length2;
                        j(audioInfo2.URL, r16, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.mobileqq.wink.editor.tts.source.TTSInterfaceDataSource$downloadTTSList$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                                invoke(bool.booleanValue(), num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z17, int i26) {
                                boolean g16;
                                Object orNull;
                                TTSAudioItem.this.setDownloadStatus(z17 ? 2 : 0);
                                String str3 = "";
                                TTSAudioItem.this.setLocalPath(z17 ? r16 : "");
                                TTSAudioItem.this.setDuration(z17 ? this.q(r16) : -1L);
                                objectRef4.element[i17] = Boolean.valueOf(z17);
                                objectRef3.element[i17] = z17;
                                if (z17) {
                                    TTSInterfaceDataSource tTSInterfaceDataSource = this;
                                    int templateType = audioInfo.getTemplateType();
                                    String[] texts = audioInfo.getTexts();
                                    if (texts != null) {
                                        orNull = ArraysKt___ArraysKt.getOrNull(texts, i17);
                                        String str4 = (String) orNull;
                                        if (str4 != null) {
                                            str3 = str4;
                                        }
                                    }
                                    TTSAudioItem audioItem = TTSAudioItem.this;
                                    Intrinsics.checkNotNullExpressionValue(audioItem, "audioItem");
                                    tTSInterfaceDataSource.f(templateType, str3, audioItem);
                                }
                                w53.b.a("TTSInterfaceDataSource", "download tts index " + i17 + ",localPath--" + r16 + "\uff0cduration\uff1a" + TTSAudioItem.this.getDuration() + ", Type:" + audioInfo.getTemplateType());
                                g16 = this.g(objectRef4.element);
                                if (g16) {
                                    this.s(callback, audioInfo.getTemplateType(), objectRef3.element, 1000003);
                                }
                            }
                        });
                    } else {
                        i3 = i18;
                        i16 = length2;
                        str = str2;
                        objectRef = objectRef2;
                    }
                    i18 = i3 + 1;
                    i17 = i19;
                    str2 = str;
                    objectRef2 = objectRef;
                    length2 = i16;
                }
                return;
            }
        }
        s(callback, audioInfo.getTemplateType(), new boolean[0], 1000006);
    }

    @NotNull
    public final String r(@Nullable String md5) {
        ms.a.f("TTSInterfaceDataSource", "[getMusicLocalPath], md5=" + md5);
        if (md5 == null) {
            return "";
        }
        return this.cacheFilePath + File.separator + md5 + n(this, null, 1, null);
    }

    public final void u(@NotNull String[] texts, int ttsType, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        v(texts, ttsType, new TTSExtraConfig(null, null, false, 7, null), callback);
    }

    public final void v(@NotNull String[] texts, int ttsType, @Nullable TTSExtraConfig extraConfig, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.wink.b.a().addObserver(new com.tencent.mobileqq.wink.editor.tts.source.b(callback, p().t3(texts, ttsType, extraConfig).hashCode()));
    }
}
