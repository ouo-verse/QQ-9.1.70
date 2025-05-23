package com.tencent.qqnt.qbasealbum.inject;

import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.base.model.UniversalPickerFactory;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.customization.preview.AbstractPreviewLogic;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.Config;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0018\u00010\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\n\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fJ\u0012\u0010\u0012\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fJ\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\fR$\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR,\u0010#\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R,\u0010+\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b,\u0010\u001a\u001a\u0004\b\u0019\u0010-R+\u00107\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u0010;\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R+\u0010A\u001a\u00020<2\u0006\u00100\u001a\u00020<8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u00102\u001a\u0004\b,\u0010>\"\u0004\b?\u0010@R+\u0010C\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\b=\u00104\"\u0004\bB\u00106R+\u0010F\u001a\u00020/2\u0006\u00100\u001a\u00020/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b'\u00102\u001a\u0004\bD\u00104\"\u0004\bE\u00106R+\u0010H\u001a\u00020<2\u0006\u00100\u001a\u00020<8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u00102\u001a\u0004\b8\u0010>\"\u0004\bG\u0010@R\u0011\u0010\u0005\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b%\u0010IR\u0013\u0010L\u001a\u0004\u0018\u00010J8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010KR\u0011\u0010O\u001a\u00020M8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/inject/QAlbumPickerContext;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/model/Config;", DownloadInfo.spKey_Config, "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "pickerCustomize", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "previewCustomize", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment;", "fragment", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "a", "", "Ljava/lang/ref/WeakReference;", "c", "Ljava/util/List;", "stack", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "d", "Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "j", "()Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;", "setPickerCustomization", "(Lcom/tencent/qqnt/qbasealbum/customization/picker/AbstractPickerLogic;)V", "pickerCustomization", "Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "e", "Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "k", "()Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;", "setPreviewCustomization", "(Lcom/tencent/qqnt/qbasealbum/customization/preview/AbstractPreviewLogic;)V", "previewCustomization", "f", "()Ljava/util/List;", "activityList", "", "<set-?>", "g", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "()Z", "t", "(Z)V", "isFlashPicEnable", tl.h.F, "p", "y", "isSingleMode", "", "i", "()I", "u", "(I)V", "fromChatType", "w", "needActivityResult", "o", HippyTKDListViewAdapter.X, "isQualityRawShow", "v", "minSendMediaSize", "()Lcom/tencent/qqnt/qbasealbum/model/Config;", "", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/qqnt/qbasealbum/base/model/d;", "()Lcom/tencent/qqnt/qbasealbum/base/model/d;", "mediaPickerFactory", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QAlbumPickerContext {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QAlbumPickerContext f361201a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f361202b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<QAlbumBaseMainFragment<?>>> stack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> pickerCustomization;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> previewCustomization;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<WeakReference<FragmentActivity>> activityList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty isFlashPicEnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty isSingleMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty fromChatType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty needActivityResult;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty isQualityRawShow;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReadWriteProperty minSendMediaSize;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        f361202b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "isFlashPicEnable", "isFlashPicEnable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "isSingleMode", "isSingleMode()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "fromChatType", "getFromChatType()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "needActivityResult", "getNeedActivityResult()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "isQualityRawShow", "isQualityRawShow()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QAlbumPickerContext.class, "minSendMediaSize", "getMinSendMediaSize()I", 0))};
        f361201a = new QAlbumPickerContext();
        stack = new ArrayList();
        activityList = new ArrayList();
        Delegates delegates = Delegates.INSTANCE;
        isFlashPicEnable = delegates.notNull();
        isSingleMode = delegates.notNull();
        fromChatType = delegates.notNull();
        needActivityResult = delegates.notNull();
        isQualityRawShow = delegates.notNull();
        minSendMediaSize = delegates.notNull();
    }

    QAlbumPickerContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            stack.clear();
            activityList.clear();
        }
    }

    public final void b(@NotNull final FragmentActivity activity) {
        boolean z16;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData;
        com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> photoCommonData2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        ox3.a.c("QBaseAlbum.PickerContext", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext$destroy$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FragmentActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "QAlbumPickerContext destroy, activity:" + FragmentActivity.this;
            }
        });
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPickerLogic = pickerCustomization;
        boolean z17 = true;
        if (abstractPickerLogic != null && (photoCommonData2 = abstractPickerLogic.getPhotoCommonData()) != null && photoCommonData2.k(activity)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ox3.a.c("QBaseAlbum.PickerContext", QAlbumPickerContext$destroy$2.INSTANCE);
            pickerCustomization = null;
        }
        AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> abstractPreviewLogic = previewCustomization;
        if (abstractPreviewLogic == null || (photoCommonData = abstractPreviewLogic.getPhotoCommonData()) == null || !photoCommonData.k(activity)) {
            z17 = false;
        }
        if (z17) {
            ox3.a.c("QBaseAlbum.PickerContext", QAlbumPickerContext$destroy$3.INSTANCE);
            previewCustomization = null;
        }
    }

    @NotNull
    public final List<WeakReference<FragmentActivity>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return activityList;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        QAlbumBaseMainFragment<?> l3 = l();
        if (l3 == null) {
            return "";
        }
        return l3.Bh();
    }

    @NotNull
    public final Config e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Config) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        QAlbumBaseMainFragment<?> l3 = l();
        if (l3 == null) {
            Config.Companion companion = Config.INSTANCE;
            return new Config.a().a();
        }
        return l3.Ch();
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return ((Number) fromChatType.getValue(this, f361202b[2])).intValue();
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.base.model.d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (com.tencent.qqnt.qbasealbum.base.model.d) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        QAlbumBaseMainFragment<?> l3 = l();
        if (l3 == null) {
            return new UniversalPickerFactory(false, null, 2, 0 == true ? 1 : 0);
        }
        return l3.Gh();
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return ((Number) minSendMediaSize.getValue(this, f361202b[5])).intValue();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return ((Boolean) needActivityResult.getValue(this, f361202b[3])).booleanValue();
    }

    @Nullable
    public final AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbstractPickerLogic) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return pickerCustomization;
    }

    @Nullable
    public final AbstractPreviewLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AbstractPreviewLogic) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return previewCustomization;
    }

    @Nullable
    public final QAlbumBaseMainFragment<?> l() {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (QAlbumBaseMainFragment) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        List<WeakReference<QAlbumBaseMainFragment<?>>> list = stack;
        if (!list.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            return (QAlbumBaseMainFragment) ((WeakReference) last).get();
        }
        return null;
    }

    public final void m(@NotNull final FragmentActivity activity, @NotNull Config config, @Nullable Class<? extends PickerCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> pickerCustomize, @Nullable Class<? extends PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> previewCustomize) {
        PickerCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a> pickerCustomizationBase;
        Constructor<? extends PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> constructor;
        Constructor<? extends PickerCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> constructor2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, config, pickerCustomize, previewCustomize);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        ox3.a.c("QBaseAlbum.PickerContext", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext$init$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FragmentActivity.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "QAlbumPickerContext init, activity:" + FragmentActivity.this;
            }
        });
        com.tencent.qqnt.qbasealbum.customization.common.b bVar = new com.tencent.qqnt.qbasealbum.customization.common.b(activity);
        t(config.s());
        y(config.v());
        u(config.c());
        v(config.j());
        w(config.k());
        x(config.u());
        PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a> previewCustomizationBase = null;
        if (pickerCustomize != null && (constructor2 = pickerCustomize.getConstructor(FragmentActivity.class, com.tencent.qqnt.qbasealbum.customization.common.b.class)) != null) {
            pickerCustomizationBase = constructor2.newInstance(activity, bVar);
        } else {
            pickerCustomizationBase = null;
        }
        pickerCustomization = pickerCustomizationBase;
        if (previewCustomize != null && (constructor = previewCustomize.getConstructor(FragmentActivity.class, com.tencent.qqnt.qbasealbum.customization.common.b.class)) != null) {
            previewCustomizationBase = constructor.newInstance(activity, bVar);
        }
        previewCustomization = previewCustomizationBase;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ((Boolean) isFlashPicEnable.getValue(this, f361202b[0])).booleanValue();
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return ((Boolean) isQualityRawShow.getValue(this, f361202b[4])).booleanValue();
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return ((Boolean) isSingleMode.getValue(this, f361202b[1])).booleanValue();
    }

    public final void q(@NotNull FragmentActivity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activityList.add(new WeakReference<>(activity));
        }
    }

    public final void r(@NotNull QAlbumBaseMainFragment<?> fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) fragment);
        } else {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            stack.add(new WeakReference<>(fragment));
        }
    }

    public final void s(@NotNull FragmentActivity activity) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Iterator<T> it = activityList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), activity)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            activityList.remove(weakReference);
        }
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            isFlashPicEnable.setValue(this, f361202b[0], Boolean.valueOf(z16));
        }
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            fromChatType.setValue(this, f361202b[2], Integer.valueOf(i3));
        }
    }

    public final void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            minSendMediaSize.setValue(this, f361202b[5], Integer.valueOf(i3));
        }
    }

    public final void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            needActivityResult.setValue(this, f361202b[3], Boolean.valueOf(z16));
        }
    }

    public final void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            isQualityRawShow.setValue(this, f361202b[4], Boolean.valueOf(z16));
        }
    }

    public final void y(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            isSingleMode.setValue(this, f361202b[1], Boolean.valueOf(z16));
        }
    }

    public final void z(@NotNull QAlbumBaseMainFragment<?> fragment) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Iterator<T> it = stack.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((WeakReference) obj).get(), fragment)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference != null) {
            stack.remove(weakReference);
        }
    }
}
