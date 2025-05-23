package com.tencent.qqnt.emotion.stickerrecommended.config;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import com.tencent.qqnt.emotion.stickerrecommended.config.CacheVersionParser;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.util.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001\u0019B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\t\u001a\u00020\u0002*\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0015\u001a\u00020\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010/\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00105\u001a\u0002002\u0006\u0010*\u001a\u0002008\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/io/File;", "file", "", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/f;", "t", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", "j", "u", "", "o", "i", "y", DomainData.DOMAIN_NAME, "r", "usrTxt", "Lcom/tencent/qqnt/emotion/stickerrecommended/g;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/emotion/stickerrecommended/config/d;", "a", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/d;", "configInfo", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/CacheVersionParser$a;", "b", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/CacheVersionParser$a;", "cacheVersionInfo", "", "c", "Ljava/util/List;", "usrTxtStickerRecEmojiList", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "d", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mmKvUtil", "value", "e", "Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "lastMD5", "", "f", "J", "w", "(J)V", "cacheVersion", "Ljava/util/concurrent/atomic/AtomicBoolean;", "g", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDownloading", "<init>", "()V", tl.h.F, "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class StickerRecConfigManager {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final StickerRecConfigManager f356494i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d configInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CacheVersionParser.a cacheVersionInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<f> usrTxtStickerRecEmojiList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmKvUtil;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastMD5;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long cacheVersion;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isDownloading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager$a;", "", "", "b", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager;", "INSTANCE", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager;", "a", "()Lcom/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager;", "", "CONFIG_JSON_FILE_NAME", "Ljava/lang/String;", "KEY_CACHE_VERSION", "KEY_MD5", "KEY_STICKER_REC_EMOJI_LIST", "TAG", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final StickerRecConfigManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return StickerRecConfigManager.f356494i;
            }
            return (StickerRecConfigManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @JvmStatic
        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_sticker_rec_emoji_8992_114867947", true);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/qqnt/emotion/stickerrecommended/config/StickerRecConfigManager$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/f;", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends TypeToken<List<f>> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31648);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            f356494i = new StickerRecConfigManager();
        }
    }

    StickerRecConfigManager() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.usrTxtStickerRecEmojiList = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(StickerRecConfigManager$mmKvUtil$2.INSTANCE);
        this.mmKvUtil = lazy;
        String decodeString = l().decodeString("key_sticker_rec_md5", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "mmKvUtil.decodeString(KEY_MD5, \"\")");
        this.lastMD5 = decodeString;
        this.cacheVersion = l().decodeLong("key_cache_version", 0L);
        this.isDownloading = new AtomicBoolean(false);
        q();
        u();
    }

    private final void j() {
        l().encodeString("key_sticker_rec_emoji_list", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(final f fVar) {
        boolean z16;
        String b16 = fVar.b();
        if (b16 != null && b16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecConfigManager", 2, "downloadStickerRecInfoItem query(" + fVar.b() + ") is null or empty return");
                return;
            }
            return;
        }
        new a(fVar.a()).c(new Function2<Integer, Integer, Unit>() { // from class: com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigManager$downloadStickerRecInfoItem$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("StickerRecConfigManager", 2, "downloadStickerRecInfoItem query: " + f.this.b() + " download success: " + i3 + ", failed: " + i16);
                }
            }
        });
    }

    private final MMKVOptionEntity l() {
        return (MMKVOptionEntity) this.mmKvUtil.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m() {
        StringBuilder sb5 = new StringBuilder(com.tencent.qqnt.emotion.utils.h.f356687a);
        sb5.append("sticker_rec");
        String str = File.separator;
        sb5.append(str);
        sb5.append("res");
        sb5.append(str);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @JvmStatic
    public static final boolean p() {
        return INSTANCE.b();
    }

    private final void q() {
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        this.configInfo = (d) ((IAIOUniteConfigApi) companion.a(IAIOUniteConfigApi.class)).loadConfig("101571");
        this.cacheVersionInfo = (CacheVersionParser.a) ((IAIOUniteConfigApi) companion.a(IAIOUniteConfigApi.class)).loadConfig("101533");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<f> t(File file) {
        String e16 = com.tencent.qqnt.emotion.utils.h.e(file);
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecConfigManager", 2, "download read file from config content: " + e16);
        }
        try {
            h hVar = (h) new Gson().fromJson(e16, h.class);
            if (hVar == null) {
                return new ArrayList();
            }
            return hVar.a();
        } catch (JsonSyntaxException e17) {
            if (QLog.isColorLevel()) {
                QLog.e("StickerRecConfigManager", 2, e17, new Object[0]);
            }
            return new ArrayList();
        }
    }

    private final void u() {
        boolean z16;
        String decodeString = l().decodeString("key_sticker_rec_emoji_list", "");
        if (decodeString != null && decodeString.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            List list = (List) new Gson().fromJson(decodeString, new b().getType());
            this.usrTxtStickerRecEmojiList.clear();
            List<f> list2 = this.usrTxtStickerRecEmojiList;
            Intrinsics.checkNotNullExpressionValue(list, "list");
            list2.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        l().encodeString("key_sticker_rec_emoji_list", new Gson().toJson(this.usrTxtStickerRecEmojiList));
    }

    private final void w(long j3) {
        this.cacheVersion = j3;
        l().encodeLong("key_cache_version", this.cacheVersion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(String str) {
        this.lastMD5 = str;
        l().encodeString("key_sticker_rec_md5", this.lastMD5);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        x("");
        this.usrTxtStickerRecEmojiList.clear();
        j();
    }

    public final boolean n() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        q();
        String str2 = this.lastMD5;
        d dVar = this.configInfo;
        String str3 = null;
        if (dVar != null) {
            str = dVar.a();
        } else {
            str = null;
        }
        boolean z16 = !Intrinsics.areEqual(str2, str);
        if (QLog.isColorLevel()) {
            String str4 = this.lastMD5;
            d dVar2 = this.configInfo;
            if (dVar2 != null) {
                str3 = dVar2.a();
            }
            QLog.i("StickerRecConfigManager", 2, "lastMD5: " + str4 + ", configInfo md5: " + str3 + ", isExpired " + z16);
        }
        return z16;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        q();
        CacheVersionParser.a aVar = this.cacheVersionInfo;
        if (aVar == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecConfigManager", 2, "isNeedClean, old version: " + this.cacheVersion + ", new version: " + aVar.a());
        }
        if (aVar.a() <= this.cacheVersion) {
            return false;
        }
        return true;
    }

    public final void r() {
        String str;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.isDownloading.get()) {
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecConfigManager", 2, "preDownloadIfNeed is downloading return");
                return;
            }
            return;
        }
        if (!n()) {
            if (QLog.isColorLevel()) {
                QLog.i("StickerRecConfigManager", 2, "download is not expired");
            }
            this.isDownloading.set(false);
            return;
        }
        if (this.configInfo == null) {
            QLog.i("StickerRecConfigManager", 1, "preDownloadIfNeed config info is null");
            return;
        }
        i();
        d dVar = this.configInfo;
        String str2 = null;
        if (dVar != null) {
            str = dVar.b();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            d dVar2 = this.configInfo;
            if (dVar2 != null) {
                str2 = dVar2.a();
            }
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                final d dVar3 = this.configInfo;
                if (dVar3 != null) {
                    this.isDownloading.set(true);
                    com.tencent.qqnt.emotion.stickerrecommended.config.b.a(dVar3.b(), m(), dVar3.a() + ".zip", new Function1<String, Unit>(this) { // from class: com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigManager$preDownloadIfNeed$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ StickerRecConfigManager this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.this$0 = this;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this, (Object) this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                            invoke2(str3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String it) {
                            String m3;
                            List t16;
                            List list;
                            List list2;
                            AtomicBoolean atomicBoolean;
                            AtomicBoolean atomicBoolean2;
                            AtomicBoolean atomicBoolean3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            c cVar = c.f356514a;
                            if (cVar.g(it, d.this.a())) {
                                m3 = this.this$0.m();
                                String str3 = File.separator;
                                String str4 = m3 + str3 + d.this.a();
                                if (!cVar.f(it, str4)) {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("StickerRecConfigManager", 2, "download unzip file(" + it + ") failed");
                                    }
                                    atomicBoolean2 = this.this$0.isDownloading;
                                    atomicBoolean2.set(false);
                                    cVar.c(cVar.e(it));
                                    return;
                                }
                                t16 = this.this$0.t(cVar.e(str4 + str3 + "softPush.json"));
                                if (QLog.isColorLevel()) {
                                    int size = t16.size();
                                    Object[] array = t16.toArray(new f[0]);
                                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                    String arrays = Arrays.toString(array);
                                    Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
                                    QLog.i("StickerRecConfigManager", 2, "preDownloadIfNeed stickerRecInfos size: " + size + ", stickerRecInfos: " + arrays);
                                }
                                StickerRecConfigManager stickerRecConfigManager = this.this$0;
                                Iterator it5 = t16.iterator();
                                while (it5.hasNext()) {
                                    stickerRecConfigManager.k((f) it5.next());
                                }
                                list = this.this$0.usrTxtStickerRecEmojiList;
                                list.clear();
                                list2 = this.this$0.usrTxtStickerRecEmojiList;
                                list2.addAll(t16);
                                this.this$0.v();
                                this.this$0.x(d.this.a());
                                atomicBoolean = this.this$0.isDownloading;
                                atomicBoolean.set(false);
                                c cVar2 = c.f356514a;
                                cVar2.c(cVar2.e(it));
                                cVar2.c(cVar2.e(str4));
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("StickerRecConfigManager", 2, "download verify file(" + it + ") md5 failed");
                            }
                            atomicBoolean3 = this.this$0.isDownloading;
                            atomicBoolean3.set(false);
                            cVar.c(cVar.e(it));
                        }
                    }, new Function1<String, Unit>() { // from class: com.tencent.qqnt.emotion.stickerrecommended.config.StickerRecConfigManager$preDownloadIfNeed$1$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StickerRecConfigManager.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                            invoke2(str3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull String it) {
                            AtomicBoolean atomicBoolean;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (QLog.isColorLevel()) {
                                QLog.i("StickerRecConfigManager", 2, "download config file(" + it + ") failed");
                            }
                            atomicBoolean = StickerRecConfigManager.this.isDownloading;
                            atomicBoolean.set(false);
                            c cVar = c.f356514a;
                            cVar.c(cVar.e(it));
                        }
                    });
                    return;
                }
                return;
            }
        }
        QLog.i("StickerRecConfigManager", 1, "download config info url is empty, or md5 is empty, configInfo: " + this.configInfo);
        this.isDownloading.set(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r3 == null) goto L27;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.tencent.qqnt.emotion.stickerrecommended.g> s(@NotNull String usrTxt) {
        List<e> list;
        Object obj;
        int collectionSizeOrDefault;
        int i3;
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) usrTxt);
        }
        Intrinsics.checkNotNullParameter(usrTxt, "usrTxt");
        Iterator<T> it = this.usrTxtStickerRecEmojiList.iterator();
        while (true) {
            list = null;
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((f) obj).b(), usrTxt)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        if (fVar != null) {
            list = fVar.a();
        }
        int i16 = 0;
        if (QLog.isColorLevel()) {
            String d16 = k.d(usrTxt);
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (list != null) {
                Object[] array = list.toArray(new e[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                objArr = (e[]) array;
            }
            objArr = new Object[0];
            QLog.i("StickerRecConfigManager", 2, "query usrTxt: " + d16 + ", result size: " + i3 + ", queryList: " + k.d(Arrays.toString(objArr)));
        }
        if (list != null) {
            List<e> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Object obj2 : list2) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(g.a((e) obj2, i16));
                i16 = i17;
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public final void y() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        CacheVersionParser.a aVar = this.cacheVersionInfo;
        if (aVar != null) {
            j3 = aVar.a();
        } else {
            j3 = 0;
        }
        w(j3);
    }
}
