package com.tencent.mobileqq.wink.edit.manager;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.reflect.TypeToken;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkInitManager;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkTextFontManager;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\bH\u0003J\b\u0010\n\u001a\u00020\bH\u0003J'\u0010\u000e\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\bH\u0007J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170!J(\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020#J\u0010\u0010'\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010(\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010)\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u001a\u0010*\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020#J\u0012\u0010+\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0016\u0010.\u001a\u00020\b2\u000e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/WinkTextFontManager;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "", "t", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)[Ljava/lang/String;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "fontList", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "resDownloadListener", tl.h.F, "([Ljava/lang/String;Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;)V", "id", "", "y", "", "downloadResults", ReportConstant.COSTREPORT_PREFIX, MessageForRichState.SIGN_MSG_FONT_ID, "Lcom/tencent/mobileqq/wink/edit/bean/AEEditorDownloadResBean;", "v", DomainData.DOMAIN_NAME, "fontBean", "r", "resDownLoadListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", HippyTKDListViewAdapter.X, "", "usage", "Landroid/util/Pair;", "B", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "u", "w", "", "preDownloadList", "g", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTextFontManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, AEEditorDownloadResBean> f318364b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, AEEditorDownloadResBean> f318365c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, AEEditorDownloadResBean> f318366d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, AEEditorDownloadResBean> f318367e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static int f318368f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f318369g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f318370h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f318371i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f318372j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkTextFontManager> f318373k;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\rR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/edit/manager/WinkTextFontManager$a;", "", "Lcom/tencent/mobileqq/wink/edit/manager/WinkTextFontManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/edit/manager/WinkTextFontManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "FONT_ID_SEPARATOR", "Ljava/lang/String;", "", "FONT_USAGE_CIRCLE", "I", "FONT_USAGE_GIF", "TAG", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/wink/edit/bean/AEEditorDownloadResBean;", "defaultFontConfigMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "defaultFontConfigSetupFinish", "Z", "fontQCircleConfigSetupFinish", "maxPagFontCacheNum", "qCircleFontConfigMap", "retryQCircleFlag", "textFontConfigMap", "textFontConfigSetupFinish", "usedPagFontMap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.edit.manager.WinkTextFontManager$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkTextFontManager a() {
            return (WinkTextFontManager) WinkTextFontManager.f318373k.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/WinkTextFontManager$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f318374a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f318375b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean[] f318376c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f318377d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318378e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WinkTextFontManager f318379f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f318380g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f318381h;

        b(AtomicInteger atomicInteger, String str, boolean[] zArr, int i3, ResDownLoadListener resDownLoadListener, WinkTextFontManager winkTextFontManager, AtomicInteger atomicInteger2, int i16) {
            this.f318374a = atomicInteger;
            this.f318375b = str;
            this.f318376c = zArr;
            this.f318377d = i3;
            this.f318378e = resDownLoadListener;
            this.f318379f = winkTextFontManager;
            this.f318380g = atomicInteger2;
            this.f318381h = i16;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            int decrementAndGet = this.f318374a.decrementAndGet();
            ms.a.a("WinkTextFontManager", " downloaded font:" + this.f318375b + "," + decrementAndGet);
            boolean[] zArr = this.f318376c;
            zArr[this.f318377d] = isSuccess;
            if (decrementAndGet == 0) {
                ResDownLoadListener resDownLoadListener = this.f318378e;
                if (resDownLoadListener != null) {
                    resDownLoadListener.onDownloadFinish(this.f318379f.s(zArr));
                }
                ms.a.a("WinkTextFontManager", " download font:" + this.f318375b);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            ResDownLoadListener resDownLoadListener = this.f318378e;
            if (resDownLoadListener != null) {
                resDownLoadListener.onProgressUpdate(this.f318380g.addAndGet((int) (progress / this.f318381h)));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/WinkTextFontManager$c", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "t", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Observer<List<? extends MetaCategory>> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f318383e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318384f;

        c(String str, ResDownLoadListener resDownLoadListener) {
            this.f318383e = str;
            this.f318384f = resDownLoadListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkTextFontManager this$0, String id5, ResDownLoadListener resDownLoadListener) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(id5, "$id");
            this$0.A(id5, resDownLoadListener);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> t16) {
            WinkEditorResourceManager.a1().X1().removeObserver(this);
            WinkTextFontManager.this.p();
            WinkTextFontManager.f318372j = false;
            final WinkTextFontManager winkTextFontManager = WinkTextFontManager.this;
            final String str = this.f318383e;
            final ResDownLoadListener resDownLoadListener = this.f318384f;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ap
                @Override // java.lang.Runnable
                public final void run() {
                    WinkTextFontManager.c.c(WinkTextFontManager.this, str, resDownLoadListener);
                }
            }, 128, null, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/WinkTextFontManager$d", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/tencent/mobileqq/wink/edit/bean/AEEditorDownloadResBean;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends TypeToken<List<? extends AEEditorDownloadResBean>> {
        d() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/edit/manager/WinkTextFontManager$e", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f318385a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f318386b;

        e(String str, ResDownLoadListener resDownLoadListener) {
            this.f318385a = str;
            this.f318386b = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            ms.a.a("WinkTextFontManager", " downloaded " + this.f318385a);
            ResDownLoadListener resDownLoadListener = this.f318386b;
            if (resDownLoadListener != null) {
                resDownLoadListener.onDownloadFinish(isSuccess);
                ms.a.a("WinkTextFontManager", " downloaded listener: " + this.f318385a);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
            ResDownLoadListener resDownLoadListener = this.f318386b;
            if (resDownLoadListener != null) {
                resDownLoadListener.onProgressUpdate(progress);
            }
        }
    }

    static {
        Lazy<WinkTextFontManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkTextFontManager>() { // from class: com.tencent.mobileqq.wink.edit.manager.WinkTextFontManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkTextFontManager invoke() {
                return new WinkTextFontManager(null);
            }
        });
        f318373k = lazy;
    }

    public /* synthetic */ WinkTextFontManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(String id5, ResDownLoadListener resDownLoadListener) {
        AEEditorDownloadResBean v3 = v(id5);
        if (v3 != null) {
            ms.a.a("WinkTextFontManager", "start download " + v3.getId());
            WinkEditorResourceManager.a1().h(v3, new e(id5, resDownLoadListener));
            return;
        }
        ms.a.f("WinkTextFontManager", "id not exist:" + id5);
        f318371i = false;
        f318370h = false;
        k(id5, resDownLoadListener);
    }

    private final void h(String[] fontList, ResDownLoadListener resDownloadListener) {
        int i3;
        int i16;
        int i17;
        int i18;
        String[] strArr = fontList;
        ResDownLoadListener resDownLoadListener = resDownloadListener;
        int length = strArr.length;
        AtomicInteger atomicInteger = new AtomicInteger(length);
        boolean[] zArr = new boolean[length];
        o();
        q();
        p();
        int i19 = 0;
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        int i26 = 0;
        while (i26 < length) {
            String str = strArr[i26];
            int length2 = str.length() - 1;
            int i27 = i19;
            int i28 = i27;
            while (i27 <= length2) {
                if (i28 == 0) {
                    i17 = i27;
                } else {
                    i17 = length2;
                }
                if (Intrinsics.compare((int) str.charAt(i17), 32) <= 0) {
                    i18 = 1;
                } else {
                    i18 = i19;
                }
                if (i28 == 0) {
                    if (i18 == 0) {
                        i28 = 1;
                    } else {
                        i27++;
                    }
                } else if (i18 == 0) {
                    break;
                } else {
                    length2--;
                }
            }
            String obj = str.subSequence(i27, length2 + 1).toString();
            ms.a.a("WinkTextFontManager", " check font " + obj);
            if (y(obj)) {
                int decrementAndGet = atomicInteger.decrementAndGet();
                ms.a.a("WinkTextFontManager", "exist font: " + obj + ", " + decrementAndGet);
                if (resDownLoadListener != null) {
                    resDownLoadListener.onProgressUpdate(atomicInteger2.addAndGet((int) (100 / length)));
                }
                zArr[i26] = true;
                if (decrementAndGet == 0) {
                    if (resDownLoadListener != null) {
                        resDownLoadListener.onDownloadFinish(s(zArr));
                    }
                    ms.a.a("WinkTextFontManager", "download exist font:" + obj);
                }
                i3 = i26;
                i16 = i19;
            } else {
                ms.a.a("WinkTextFontManager", " start download font:" + obj);
                i3 = i26;
                i16 = i19;
                A(obj, new b(atomicInteger, obj, zArr, i26, resDownloadListener, this, atomicInteger2, length));
            }
            i26 = i3 + 1;
            strArr = fontList;
            resDownLoadListener = resDownloadListener;
            i19 = i16;
        }
    }

    private final void k(final String id5, final ResDownLoadListener resDownLoadListener) {
        ms.a.f("WinkTextFontManager", "checkAndRequestQCircleFont retryQCircleFlag: " + f318372j);
        if (f318372j) {
            return;
        }
        if (!new File(u53.f.f438405r, "editor_text_update_template.json").exists()) {
            ms.a.f("WinkTextFontManager", "checkAndRequestQCircleFont retry");
            f318372j = true;
            WinkInitManager.INSTANCE.a().g();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.edit.manager.ao
                @Override // java.lang.Runnable
                public final void run() {
                    WinkTextFontManager.l(WinkTextFontManager.this, id5, resDownLoadListener);
                }
            });
            return;
        }
        ms.a.f("WinkTextFontManager", "checkAndRequestQCircleFont retry false");
        if (resDownLoadListener != null) {
            resDownLoadListener.onDownloadFinish(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WinkTextFontManager this$0, String id5, ResDownLoadListener resDownLoadListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id5, "$id");
        WinkEditorResourceManager.a1().X1().observeForever(new c(id5, resDownLoadListener));
    }

    private final boolean m(AEEditorDownloadResBean fontBean) {
        if (fontBean.getPreDownload() == 1 && !WinkEditorResourceManager.a1().r(fontBean)) {
            return true;
        }
        return false;
    }

    private final boolean n(String fontId) {
        boolean z16;
        ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318367e;
        synchronized (concurrentHashMap) {
            z16 = false;
            if (concurrentHashMap.get(fontId) == null) {
                if (concurrentHashMap.size() >= f318368f) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void p() {
        Object obj;
        if (f318371i) {
            w53.b.f("WinkTextFontManager", "already ensure config qcircleFontConfigMap");
            return;
        }
        f318371i = true;
        List<MetaCategory> S1 = WinkEditorResourceManager.a1().S1();
        if (S1 != null) {
            obj = Integer.valueOf(S1.size());
        } else {
            obj = "null";
        }
        w53.b.f("WinkTextFontManager", "ensureSetupQCircleFontConfigMap---size = " + obj);
        if (S1 != null) {
            Iterator<MetaCategory> it = S1.iterator();
            while (it.hasNext()) {
                Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next = it5.next();
                    AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                    aEEditorDownloadResBean.setId(next.f30533id);
                    aEEditorDownloadResBean.setUrl(next.packageUrl);
                    aEEditorDownloadResBean.setMd5(next.packageMd5);
                    String str = next.additionalFields.get("preDownload");
                    if (str != null) {
                        aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
                    }
                    ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318366d;
                    String str2 = next.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str2, "metaMaterial.id");
                    concurrentHashMap.put(str2, aEEditorDownloadResBean);
                }
            }
        }
    }

    @WorkerThread
    private final void q() {
        Object obj;
        if (f318370h) {
            w53.b.f("WinkTextFontManager", "already ensure config textFontConfigMap");
            return;
        }
        f318370h = new File(u53.f.f438405r, "editor_text_font.json").exists();
        List<MetaCategory> W1 = WinkEditorResourceManager.a1().W1();
        if (W1 != null) {
            obj = Integer.valueOf(W1.size());
        } else {
            obj = "null";
        }
        w53.b.f("WinkTextFontManager", "ensureSetupTextFontConfigMap---size = " + obj);
        if (W1 != null) {
            Iterator<MetaCategory> it = W1.iterator();
            while (it.hasNext()) {
                Iterator<MetaMaterial> it5 = it.next().materials.iterator();
                while (it5.hasNext()) {
                    MetaMaterial next = it5.next();
                    AEEditorDownloadResBean aEEditorDownloadResBean = new AEEditorDownloadResBean();
                    aEEditorDownloadResBean.setId(next.f30533id);
                    aEEditorDownloadResBean.setUrl(next.packageUrl);
                    aEEditorDownloadResBean.setMd5(next.packageMd5);
                    String str = next.additionalFields.get("preDownload");
                    if (str != null) {
                        aEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
                    }
                    ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318365c;
                    String str2 = next.f30533id;
                    Intrinsics.checkNotNullExpressionValue(str2, "metaMaterial.id");
                    concurrentHashMap.put(str2, aEEditorDownloadResBean);
                }
            }
        }
    }

    private final String r(AEEditorDownloadResBean fontBean) {
        String n3 = WinkEditorResourceManager.a1().n(fontBean);
        Intrinsics.checkNotNullExpressionValue(n3, "getInstance().getDownloadFolderBackup(fontBean)");
        String str = n3 + File.separator + fontBean.getId();
        if (new File(str).exists()) {
            return str;
        }
        String str2 = str + ".ttf";
        if (new File(str2).exists()) {
            return str2;
        }
        String str3 = str + ".otf";
        if (!new File(str3).exists()) {
            return null;
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(boolean[] downloadResults) {
        for (boolean z16 : downloadResults) {
            if (!z16) {
                return false;
            }
        }
        return true;
    }

    private final String[] t(MetaMaterial metaMaterial) {
        Map<String, String> map;
        List<String> split;
        Object[] objArr = null;
        if (metaMaterial != null && (map = metaMaterial.additionalFields) != null) {
            String str = map.get("fontID");
            ms.a.a("WinkTextFontManager", metaMaterial.f30533id + ", has font" + str);
            if (!TextUtils.isEmpty(str)) {
                if (str != null && (split = new Regex(",").split(str, 0)) != null) {
                    Object[] array = split.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    objArr = (String[]) array;
                }
                if (objArr != null) {
                    HashSet hashSet = new HashSet();
                    Collections.addAll(hashSet, Arrays.copyOf(objArr, objArr.length));
                    objArr = hashSet.toArray(new String[0]);
                    Intrinsics.checkNotNull(objArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
        }
        return (String[]) objArr;
    }

    private final AEEditorDownloadResBean v(String fontId) {
        if (fontId == null) {
            return null;
        }
        ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318364b;
        if (concurrentHashMap.get(fontId) != null) {
            return concurrentHashMap.get(fontId);
        }
        ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap2 = f318365c;
        if (concurrentHashMap2.get(fontId) != null) {
            return concurrentHashMap2.get(fontId);
        }
        ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap3 = f318366d;
        if (concurrentHashMap3.get(fontId) == null) {
            return null;
        }
        return concurrentHashMap3.get(fontId);
    }

    private final boolean y(String id5) {
        AEEditorDownloadResBean w3 = w(id5);
        if (w3 != null && WinkEditorResourceManager.a1().r(w3)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Pair<String, String> B(@Nullable String fontId, int usage) {
        String str;
        Pair<String, String> pair;
        AEEditorDownloadResBean w3 = w(fontId);
        if (w3 != null) {
            str = r(w3);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            w53.b.c("WinkTextFontManager", "font:" + fontId + " not find.");
            return new Pair<>(str, AEEditorConstants.GetFontResult.ERROR_CANNOT_FIND_VALID_FONT);
        }
        if (usage == 1) {
            return new Pair<>(str, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        if (n(fontId)) {
            w53.b.c("WinkTextFontManager", "fontExceededLimit.");
            return new Pair<>(str, AEEditorConstants.GetFontResult.ERROR_EXCEEDED_FONT_LIMIT);
        }
        ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318367e;
        synchronized (concurrentHashMap) {
            AEEditorDownloadResBean v3 = v(fontId);
            if (v3 != null && fontId != null) {
                concurrentHashMap.put(fontId, v3);
            }
            pair = new Pair<>(str, AEEditorConstants.GetFontResult.SUCCESS_GET_VALID_FONT);
        }
        return pair;
    }

    public final void g(@NotNull List<AEEditorDownloadResBean> preDownloadList) {
        Intrinsics.checkNotNullParameter(preDownloadList, "preDownloadList");
        o();
        for (AEEditorDownloadResBean fontBean : f318364b.values()) {
            Intrinsics.checkNotNullExpressionValue(fontBean, "fontBean");
            if (m(fontBean)) {
                preDownloadList.add(fontBean);
            }
        }
        q();
        for (AEEditorDownloadResBean fontBean2 : f318365c.values()) {
            Intrinsics.checkNotNullExpressionValue(fontBean2, "fontBean");
            if (m(fontBean2)) {
                preDownloadList.add(fontBean2);
            }
        }
        p();
        for (AEEditorDownloadResBean fontBean3 : f318366d.values()) {
            Intrinsics.checkNotNullExpressionValue(fontBean3, "fontBean");
            if (m(fontBean3)) {
                preDownloadList.add(fontBean3);
            }
        }
    }

    public final void i(@Nullable MetaMaterial metaMaterial, @Nullable ResDownLoadListener resDownloadListener) {
        boolean z16;
        String[] t16 = t(metaMaterial);
        boolean z17 = false;
        if (t16 != null) {
            if (t16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            h(t16, resDownloadListener);
        } else if (resDownloadListener != null) {
            resDownloadListener.onDownloadFinish(true);
        }
    }

    public final void j(@Nullable MetaMaterial metaMaterial) {
        String[] t16;
        if (metaMaterial == null || (t16 = t(metaMaterial)) == null) {
            return;
        }
        ms.a.a("WinkTextFontManager", "checkAndRegisterTemplateFont size:" + t16.length);
        int length = t16.length;
        for (int i3 = 0; i3 < length; i3++) {
            String u16 = u(t16[i3], 0);
            ms.a.a("WinkTextFontManager", "checkAndRegisterTemplateFont :" + u16 + "," + com.tencent.mobileqq.wink.utils.w.e().b(u16, t16[i3]));
        }
    }

    @WorkerThread
    public final void o() {
        Object obj;
        if (f318369g) {
            return;
        }
        f318369g = true;
        String m3 = h.m("winkEdit/wink_editor_base_fonts.json");
        Intrinsics.checkNotNullExpressionValue(m3, "readAssetsFileContent(Wi\u2026DITOR_DEFAULT_FONTS_JSON)");
        if (TextUtils.isEmpty(m3)) {
            w53.b.f("WinkTextFontManager", "ensureSetupFontConfigMap---read assets json content empty");
            return;
        }
        List<AEEditorDownloadResBean> list = (List) GsonUtils.json2Obj(m3, new d().getType());
        if (list != null) {
            obj = Integer.valueOf(list.size());
        } else {
            obj = "null";
        }
        w53.b.f("WinkTextFontManager", "ensureSetupFontConfigMap---size = " + obj);
        for (AEEditorDownloadResBean aEEditorDownloadResBean : list) {
            ConcurrentHashMap<String, AEEditorDownloadResBean> concurrentHashMap = f318364b;
            String id5 = aEEditorDownloadResBean.getId();
            Intrinsics.checkNotNullExpressionValue(id5, "bean.id");
            concurrentHashMap.put(id5, aEEditorDownloadResBean);
        }
    }

    @Nullable
    public final String u(@Nullable String fontId, int usage) {
        return (String) B(fontId, usage).first;
    }

    @Nullable
    public final AEEditorDownloadResBean w(@Nullable String fontId) {
        o();
        q();
        p();
        return v(fontId);
    }

    @NotNull
    public final Map<String, AEEditorDownloadResBean> x() {
        return f318366d;
    }

    public final boolean z(@Nullable MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return false;
        }
        String[] t16 = INSTANCE.a().t(metaMaterial);
        if (t16 == null) {
            return true;
        }
        for (String str : t16) {
            if (!y(str)) {
                w53.b.a("WinkTextFontManager", "[isTemplateFontExist] font not exist" + str);
                return false;
            }
        }
        return true;
    }

    WinkTextFontManager() {
        Object b16 = y53.c.b(3, 5, 7);
        Intrinsics.checkNotNullExpressionValue(b16, "getValueByDeviceMemory(3, 5, 7)");
        f318368f = ((Number) b16).intValue();
    }
}
