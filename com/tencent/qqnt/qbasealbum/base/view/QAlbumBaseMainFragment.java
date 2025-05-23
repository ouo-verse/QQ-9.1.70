package com.tencent.qqnt.qbasealbum.base.view;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqnt.qbasealbum.album.view.PickerBottomBarPart;
import com.tencent.qqnt.qbasealbum.album.view.PickerMediaViewPagerPart;
import com.tencent.qqnt.qbasealbum.album.view.PickerTitleBarPart;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel;
import com.tencent.qqnt.qbasealbum.albumlist.view.AlbumListPart;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.InitBean;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.report.b;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\t\b&\u0018\u0000 u*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004:\u0001vB\u0007\u00a2\u0006\u0004\bs\u0010tJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH&J\u000f\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u0011H\u0016J!\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001a\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u0016\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+J\u000e\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+J\b\u0010/\u001a\u00020\rH\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0014J/\u00108\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00112\u000e\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u000204032\u0006\u00107\u001a\u000206H\u0016\u00a2\u0006\u0004\b8\u00109J\b\u0010:\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\rH\u0004R\u001b\u0010B\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010\u0014\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010ER\u001d\u0010I\u001a\u0004\u0018\u0001048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010?\u001a\u0004\bG\u0010HR\u001b\u0010\u0015\u001a\u00028\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010?\u001a\u0004\bK\u0010\fR\u001b\u0010P\u001a\u00020L8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010?\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010?\u001a\u0004\bS\u0010TR$\u0010]\u001a\u0004\u0018\u00010V8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R \u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0_0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010RR\u001d\u0010i\u001a\u0004\u0018\u00010e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010?\u001a\u0004\bg\u0010hR \u0010m\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR#\u0010r\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020(0n8\u0006\u00a2\u0006\f\n\u0004\bo\u0010l\u001a\u0004\bp\u0010q\u00a8\u0006w"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment;", "Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "T", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseFragment;", "Lcom/tencent/qqnt/qbasealbum/report/b;", "", "yh", "Oh", "Sh", "Lcom/tencent/qqnt/qbasealbum/base/model/d;", "Jh", "Dh", "()Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "", "isFromQZoneMedia", "Kh", "Mh", "", "getStatusBarColor", "Lcom/tencent/qqnt/qbasealbum/model/Config;", DownloadInfo.spKey_Config, "initBean", "Landroid/os/Bundle;", "wh", "(Lcom/tencent/qqnt/qbasealbum/model/Config;Lcom/tencent/qqnt/qbasealbum/model/InitBean;)Landroid/os/Bundle;", "xh", "Landroid/content/Context;", "context", "onAttach", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Landroidx/recyclerview/widget/RecyclerView;", "mediaList", "vh", "Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseChildFragment;", "childFragment", "Qh", "Ph", "Ih", "Rh", "Lh", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onDetach", OcrConfig.CHINESE, "D", "Lkotlin/Lazy;", "Gh", "()Lcom/tencent/qqnt/qbasealbum/base/model/d;", "mediaPickerFactory", "E", "Ch", "()Lcom/tencent/qqnt/qbasealbum/model/Config;", UserInfo.SEX_FEMALE, "Bh", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "G", "Eh", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "H", "Hh", "()Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "I", "Ah", "()Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "albumListViewModel", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "J", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "Fh", "()Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "setLocalMediaViewModel", "(Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;)V", "localMediaViewModel", "Ljava/util/LinkedList;", "Ljava/lang/ref/WeakReference;", "K", "Ljava/util/LinkedList;", "childFragmentStack", "L", "backStackEntryCount", "Lcom/google/android/material/appbar/AppBarLayout;", "M", "getTopAppbarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "topAppbarLayout", "", "N", "Ljava/util/Map;", "_mediaTypeToPageList", "", "P", "getMediaTypeToPageList", "()Ljava/util/Map;", "mediaTypeToPageList", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class QAlbumBaseMainFragment<T extends InitBean> extends QAlbumBaseFragment implements com.tencent.qqnt.qbasealbum.report.b {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerFactory;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy businessName;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy initBean;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy albumListViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private PickerLocalMediaViewModel localMediaViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LinkedList<WeakReference<QAlbumBaseChildFragment>> childFragmentStack;

    /* renamed from: L, reason: from kotlin metadata */
    private int backStackEntryCount;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy topAppbarLayout;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Map<PageType, RecyclerView> _mediaTypeToPageList;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Map<PageType, RecyclerView> mediaTypeToPageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/base/view/QAlbumBaseMainFragment$a;", "", "", "BROADCAST_MSG_ADD_MEDIA_LIST", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361059a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34990);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.TAB_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.TAB_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f361059a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35031);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QAlbumBaseMainFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.qbasealbum.base.model.d>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$mediaPickerFactory$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.qqnt.qbasealbum.base.model.d invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.this$0.Jh() : (com.tencent.qqnt.qbasealbum.base.model.d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.mediaPickerFactory = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Config>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$config$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Config invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Config) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    QAlbumBaseMainFragment<T> qAlbumBaseMainFragment = this.this$0;
                    Bundle arguments = qAlbumBaseMainFragment.getArguments();
                    Config config = arguments != null ? (Config) arguments.getParcelable("ARG_ALBUM_CONFIG") : null;
                    if (config == null) {
                        Config.Companion companion = Config.INSTANCE;
                        config = new Config.a().a();
                    }
                    return qAlbumBaseMainFragment.xh(config);
                }
            });
            this.config = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$businessName$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = this.this$0.getArguments();
                    if (arguments != null) {
                        return arguments.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
                    }
                    return null;
                }
            });
            this.businessName = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<T>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$initBean$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Incorrect return type in method signature: ()TT; */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final InitBean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (InitBean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = this.this$0.getArguments();
                    InitBean initBean = arguments != null ? (InitBean) arguments.getParcelable("ARG_PICKER_INIT_BEAN") : null;
                    InitBean initBean2 = initBean instanceof InitBean ? initBean : null;
                    return initBean2 == null ? this.this$0.Dh() : initBean2;
                }
            });
            this.initBean = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<SelectedMediaViewModel>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$selectedMediaViewModel$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SelectedMediaViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (SelectedMediaViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity requireActivity = this.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    return com.tencent.qqnt.qbasealbum.album.b.g(requireActivity);
                }
            });
            this.selectedMediaViewModel = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<AlbumListViewModel>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$albumListViewModel$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AlbumListViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.qqnt.qbasealbum.album.b.a(this.this$0) : (AlbumListViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.albumListViewModel = lazy6;
            this.childFragmentStack = new LinkedList<>();
            lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<AppBarLayout>(this) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$topAppbarLayout$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ QAlbumBaseMainFragment<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final AppBarLayout invoke() {
                    View fragmentContentView;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (AppBarLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    fragmentContentView = this.this$0.getFragmentContentView();
                    if (fragmentContentView != null) {
                        return (AppBarLayout) fragmentContentView.findViewById(R.id.f166207z02);
                    }
                    return null;
                }
            });
            this.topAppbarLayout = lazy7;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this._mediaTypeToPageList = linkedHashMap;
            this.mediaTypeToPageList = linkedHashMap;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(QAlbumBaseMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getChildFragmentManager().getBackStackEntryCount() == 0) {
            this$0.setStatusBarTextColor();
        }
        if (this$0.backStackEntryCount < this$0.getChildFragmentManager().getBackStackEntryCount()) {
            this$0.Oh();
        } else if (this$0.backStackEntryCount > this$0.getChildFragmentManager().getBackStackEntryCount()) {
            this$0.Sh();
        }
        this$0.backStackEntryCount = this$0.getChildFragmentManager().getBackStackEntryCount();
    }

    private final void Oh() {
        Object orNull;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        orNull = CollectionsKt___CollectionsKt.getOrNull(fragments, getChildFragmentManager().getFragments().size() - 2);
        Fragment fragment = (Fragment) orNull;
        if (fragment instanceof QAlbumBaseChildFragment) {
            getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitAllowingStateLoss();
        }
    }

    private final void Sh() {
        Object lastOrNull;
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "childFragmentManager.fragments");
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) fragments);
        Fragment fragment = (Fragment) lastOrNull;
        if (fragment instanceof QAlbumBaseChildFragment) {
            getChildFragmentManager().beginTransaction().setMaxLifecycle(fragment, Lifecycle.State.RESUMED).commitAllowingStateLoss();
        }
    }

    private final void yh() {
        if (Ih()) {
            ox3.a.g(getTAG(), QAlbumBaseMainFragment$fetchMediaData$1.INSTANCE);
            final long currentTimeMillis = System.currentTimeMillis();
            SelectedMediaViewModel.U1(Hh(), null, 1, null);
            PickerLocalMediaViewModel pickerLocalMediaViewModel = this.localMediaViewModel;
            if (pickerLocalMediaViewModel != null) {
                pickerLocalMediaViewModel.fetchFirstPageMedia();
            }
            ox3.a.h(new Function0<String>(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseMainFragment$fetchMediaData$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $start;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$start = currentTimeMillis;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, currentTimeMillis);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "fetchMediaData, cost:" + (System.currentTimeMillis() - this.$start);
                }
            });
        }
    }

    @NotNull
    protected final AlbumListViewModel Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AlbumListViewModel) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (AlbumListViewModel) this.albumListViewModel.getValue();
    }

    @Nullable
    public final String Bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (String) this.businessName.getValue();
    }

    @NotNull
    public final Config Ch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Config) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (Config) this.config.getValue();
    }

    @NotNull
    public abstract T Dh();

    @NotNull
    public final T Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (T) this.initBean.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final PickerLocalMediaViewModel Fh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PickerLocalMediaViewModel) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.localMediaViewModel;
    }

    @NotNull
    public final com.tencent.qqnt.qbasealbum.base.model.d Gh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.qbasealbum.base.model.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (com.tencent.qqnt.qbasealbum.base.model.d) this.mediaPickerFactory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final SelectedMediaViewModel Hh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SelectedMediaViewModel) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (SelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    public boolean Ih() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return true;
    }

    @NotNull
    public abstract com.tencent.qqnt.qbasealbum.base.model.d Jh();

    public abstract void Kh(boolean isFromQZoneMedia);

    protected void Lh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        AbstractPickerLogic<? extends com.tencent.qqnt.qbasealbum.customization.common.a> b16 = CustomizationFacade.f361084a.b();
        if (b16 != null) {
            b16.onPickerExit();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public abstract void Mh(boolean isFromQZoneMedia);

    public final void Ph(@NotNull QAlbumBaseChildFragment childFragment) {
        QAlbumBaseChildFragment qAlbumBaseChildFragment;
        QAlbumBaseMainFragment<?> l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) childFragment);
            return;
        }
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        WeakReference<QAlbumBaseChildFragment> peek = this.childFragmentStack.peek();
        if (peek != null) {
            qAlbumBaseChildFragment = peek.get();
        } else {
            qAlbumBaseChildFragment = null;
        }
        if (Intrinsics.areEqual(qAlbumBaseChildFragment, childFragment)) {
            this.childFragmentStack.pop();
            if (this.childFragmentStack.size() == 0 && !childFragment.requireActivity().isFinishing() && (l3 = QAlbumPickerContext.f361201a.l()) != null) {
                l3.u3();
            }
        }
    }

    public final void Qh(@NotNull QAlbumBaseChildFragment childFragment) {
        QAlbumBaseMainFragment<?> l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) childFragment);
            return;
        }
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        if (this.childFragmentStack.size() == 0 && (l3 = QAlbumPickerContext.f361201a.l()) != null) {
            b.a.a(l3, 0L, 1, null);
        }
        this.childFragmentStack.push(new WeakReference<>(childFragment));
    }

    public void Rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PickerTitleBarPart());
        arrayList.add(new AlbumListPart());
        arrayList.add(new PickerMediaViewPagerPart());
        if (Ch().r()) {
            arrayList.add(Gh().c());
        } else {
            arrayList.add(new PickerBottomBarPart());
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment
    public int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        QAlbumPickerContext.f361201a.r(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Application application;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            application = activity.getApplication();
        } else {
            application = null;
        }
        if (application == null) {
            Lh();
            return true;
        }
        if (Intrinsics.areEqual(Ah().U1().getValue(), Boolean.TRUE)) {
            Ah().Q1();
            return true;
        }
        if (zh()) {
            return true;
        }
        Lh();
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        PageType pageType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) savedInstanceState);
            return;
        }
        Hh().c2(Ch().f());
        Hh().b2(0);
        int i3 = b.f361059a[Ch().e().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                pageType = PageType.LOCAL_ALL;
            } else {
                pageType = PageType.LOCAL_IMAGE;
            }
        } else {
            pageType = PageType.LOCAL_VIDEO;
        }
        PickerLocalMediaViewModel b16 = com.tencent.qqnt.qbasealbum.album.b.b(this, pageType);
        b16.x2(Ah().W1());
        this.localMediaViewModel = b16;
        Intent intent = getHostActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
        b16.setIntent(intent);
        yh();
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            super.onDetach();
            QAlbumPickerContext.f361201a.z(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(requestCode), permissions, grantResults);
            return;
        }
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onResume();
        LocalMediaDataHub.INSTANCE.a().j0();
        Ah().Z1(QAlbumPickerContext.f361201a.e().e());
    }

    @Override // com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Rh();
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.tencent.qqnt.qbasealbum.base.view.b
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
                QAlbumBaseMainFragment.Nh(QAlbumBaseMainFragment.this);
            }
        });
    }

    public final void vh(@NotNull PageType pageType, @NotNull RecyclerView mediaList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) pageType, (Object) mediaList);
            return;
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        this._mediaTypeToPageList.put(pageType, mediaList);
        getPartManager().broadcastMessage("BROADCAST_MSG_ADD_MEDIA_LIST", pageType);
    }

    @NotNull
    public final Bundle wh(@Nullable Config config, @Nullable T initBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bundle) iPatchRedirector.redirect((short) 13, (Object) this, (Object) config, (Object) initBean);
        }
        Bundle bundle = new Bundle();
        if (config == null) {
            Config.Companion companion = Config.INSTANCE;
            Config.a aVar = new Config.a();
            Unit unit = Unit.INSTANCE;
            config = aVar.a();
        }
        bundle.putParcelable("ARG_ALBUM_CONFIG", config);
        if (initBean == null) {
            initBean = Dh();
        }
        bundle.putParcelable("ARG_PICKER_INIT_BEAN", initBean);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Config xh(@NotNull Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Config) iPatchRedirector.redirect((short) 14, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        return config;
    }

    protected final boolean zh() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this)).booleanValue();
        }
        if (!this.childFragmentStack.isEmpty()) {
            QAlbumBaseChildFragment qAlbumBaseChildFragment = this.childFragmentStack.pop().get();
            if (qAlbumBaseChildFragment != null && qAlbumBaseChildFragment.onBackEvent()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }
}
