package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager;
import com.tencent.mobileqq.app.message.messageclean.be;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.fragment.QQStorageManageFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.MiniGameSpaceOccupyListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\u00020\u0007*\u00020\u0005H\u0002J\f\u0010\u000b\u001a\u00020\u0007*\u00020\u0005H\u0002J\f\u0010\f\u001a\u00020\u0007*\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J&\u0010!\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014J\u001a\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\"\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010*H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020E0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020E0A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010CR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/fragment/QQStorageManageFragment;", "Lcom/tencent/mobileqq/fragment/IphoneTitleBarFragment;", "Lcom/tencent/mobileqq/activity/en;", "", "Rh", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Jh", "(Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;)[Lcom/tencent/mobileqq/widget/listitem/Group;", "Eh", "Nh", "Kh", "Qh", "Wh", "Uh", "Zh", "Vh", "ai", "Th", "Yh", "", "useQUISecNavBar", "needImmersive", "needBlur", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", "onBackPressed", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/common/app/AppInterface;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "D", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "scanSpaceManager", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "E", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "storageSize", "Ltb3/a;", UserInfo.SEX_FEMALE, "Ltb3/a;", "zootopiaSpaceOccupyListener", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager$i;", "G", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager$i;", "chatRecordListener", "Landroidx/lifecycle/MutableLiveData;", "H", "Landroidx/lifecycle/MutableLiveData;", "chatFileLiveData", "", "I", "zplanLiveData", "J", "miniGameLiveData", "Lcom/tencent/mobileqq/minigame/api/MiniGameSpaceOccupyListener;", "K", "Lcom/tencent/mobileqq/minigame/api/MiniGameSpaceOccupyListener;", "miniGameOccupyListener", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "L", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recyclerView", "<init>", "()V", "M", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQStorageManageFragment extends IphoneTitleBarFragment implements en {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private AppInterface app;

    /* renamed from: D, reason: from kotlin metadata */
    private NTScanSpaceManager scanSpaceManager;

    /* renamed from: E, reason: from kotlin metadata */
    private be storageSize;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private tb3.a zootopiaSpaceOccupyListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private NTScanSpaceManager.i chatRecordListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Unit> chatFileLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> zplanLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> miniGameLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private MiniGameSpaceOccupyListener miniGameOccupyListener;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QUISettingsRecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/fragment/QQStorageManageFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.fragment.QQStorageManageFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/QQStorageManageFragment$b", "Lcom/tencent/mobileqq/minigame/api/MiniGameSpaceOccupyListener;", "", "totalSize", "", "totalOccupiedSpaceUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements MiniGameSpaceOccupyListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageManageFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQStorageManageFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.miniGameLiveData.setValue(com.tencent.mobileqq.app.message.messageclean.q.c(j3));
        }

        @Override // com.tencent.mobileqq.minigame.api.MiniGameSpaceOccupyListener
        public void totalOccupiedSpaceUpdate(final long totalSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, totalSize);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQStorageManageFragment qQStorageManageFragment = QQStorageManageFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.x
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageManageFragment.b.b(QQStorageManageFragment.this, totalSize);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/QQStorageManageFragment$c", "Ltb3/a;", "", "totalSize", "", "totalOccupiedSpaceUpdate", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements tb3.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageManageFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQStorageManageFragment this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.zplanLiveData.setValue(com.tencent.mobileqq.app.message.messageclean.q.c(j3));
        }

        @Override // tb3.a
        public void totalOccupiedSpaceUpdate(final long totalSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, totalSize);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QQStorageManageFragment qQStorageManageFragment = QQStorageManageFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.y
                @Override // java.lang.Runnable
                public final void run() {
                    QQStorageManageFragment.c.b(QQStorageManageFragment.this, totalSize);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/fragment/QQStorageManageFragment$d", "Ltb3/b;", "", "id", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d implements tb3.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageManageFragment.this);
            }
        }

        @Override // tb3.b
        public void a(@NotNull String id5, @NotNull ZootopiaSource source) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5, (Object) source);
                return;
            }
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(source, "source");
            QLog.d("QQStorageManageFragment", 1, "onZootopiaTaskDelete id: " + id5 + ", source: " + source);
            AppInterface appInterface = QQStorageManageFragment.this.app;
            Source source2 = null;
            if (appInterface != null) {
                str = appInterface.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (str == null) {
                return;
            }
            ZootopiaSource last = source.getLast();
            if (last != null) {
                source2 = last.getMainSource();
            }
            if (source2 == Source.StorageScan) {
                LastCleanMMKVHelper.f183341a.f(str);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58228);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQStorageManageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.chatFileLiveData = new MutableLiveData<>();
        this.zplanLiveData = new MutableLiveData<>();
        this.miniGameLiveData = new MutableLiveData<>();
    }

    private final Group Eh(final QUIListItemAdapter qUIListItemAdapter) {
        String c16;
        String string = getString(R.string.zlb);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_record_file_desc)");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        String string2 = getString(R.string.ajp);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.del_local_chat_msg)");
        x.b.d dVar = new x.b.d(string2);
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        be beVar = null;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        if (nTScanSpaceManager.Z()) {
            c16 = getString(R.string.f1643125h);
        } else {
            be beVar2 = this.storageSize;
            if (beVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageSize");
                beVar2 = null;
            }
            c16 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar2.d());
        }
        String str = c16;
        Intrinsics.checkNotNullExpressionValue(str, "if (scanSpaceManager.isL\u2026ize\n                    )");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.g(str, true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageManageFragment.Fh(QQStorageManageFragment.this, view);
            }
        });
        MutableLiveData<Unit> mutableLiveData = this.chatFileLiveData;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Unit, Unit> function1 = new Function1<Unit, Unit>(xVar, this, qUIListItemAdapter) { // from class: com.tencent.mobileqq.fragment.QQStorageManageFragment$createChatGroup$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> $this_apply;
            final /* synthetic */ QUIListItemAdapter $this_createChatGroup;
            final /* synthetic */ QQStorageManageFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.this$0 = this;
                this.$this_createChatGroup = qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, xVar, this, qUIListItemAdapter);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                be beVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                beVar3 = this.this$0.storageSize;
                if (beVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageSize");
                    beVar3 = null;
                }
                String c17 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar3.d());
                Intrinsics.checkNotNullExpressionValue(c17, "getFormatSize(storageSize.chatRecordSize)");
                O.h(c17);
                this.$this_createChatGroup.l0(this.$this_apply);
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStorageManageFragment.Gh(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = xVar;
        String string3 = getString(R.string.ajg);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.del_all_download_file)");
        x.b.d dVar2 = new x.b.d(string3);
        be beVar3 = this.storageSize;
        if (beVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
        } else {
            beVar = beVar3;
        }
        String c17 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar.c());
        Intrinsics.checkNotNullExpressionValue(c17, "getFormatSize(storageSize.chatFileSize)");
        final com.tencent.mobileqq.widget.listitem.x xVar2 = new com.tencent.mobileqq.widget.listitem.x(dVar2, new x.c.g(c17, true, false, 4, null));
        xVar2.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageManageFragment.Hh(QQStorageManageFragment.this, view);
            }
        });
        MutableLiveData<Unit> mutableLiveData2 = this.chatFileLiveData;
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>(xVar2, this, qUIListItemAdapter) { // from class: com.tencent.mobileqq.fragment.QQStorageManageFragment$createChatGroup$2$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> $this_apply;
            final /* synthetic */ QUIListItemAdapter $this_createChatGroup;
            final /* synthetic */ QQStorageManageFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar2;
                this.this$0 = this;
                this.$this_createChatGroup = qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, xVar2, this, qUIListItemAdapter);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit2) {
                invoke2(unit2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit2) {
                be beVar4;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) unit2);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                beVar4 = this.this$0.storageSize;
                if (beVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageSize");
                    beVar4 = null;
                }
                String c18 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar4.c());
                Intrinsics.checkNotNullExpressionValue(c18, "getFormatSize(storageSize.chatFileSize)");
                O.h(c18);
                this.$this_createChatGroup.l0(this.$this_apply);
            }
        };
        mutableLiveData2.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.fragment.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStorageManageFragment.Ih(Function1.this, obj);
            }
        });
        aVarArr[1] = xVar2;
        return new Group("", string, aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(QQStorageManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("jump", 1);
        intent.putExtra(IQQComicPluginUtil.PPP_PRELOAD_DATA, true);
        PublicFragmentActivity.startForResult(this$0.getActivity(), intent, SessionClearFragment.class, 1001);
        ReportController.y(this$0.app, "0X800C1B2");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(QQStorageManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).openFileClear(this$0.getActivity(), 1002);
        ReportController.y(this$0.app, "0X800C1B3");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Group[] Jh(QUIListItemAdapter qUIListItemAdapter) {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Eh(qUIListItemAdapter));
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        NTScanSpaceManager nTScanSpaceManager2 = null;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        if (nTScanSpaceManager.e0()) {
            arrayListOf.add(Nh(qUIListItemAdapter));
        }
        NTScanSpaceManager nTScanSpaceManager3 = this.scanSpaceManager;
        if (nTScanSpaceManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
        } else {
            nTScanSpaceManager2 = nTScanSpaceManager3;
        }
        if (nTScanSpaceManager2.d0()) {
            arrayListOf.add(Kh(qUIListItemAdapter));
        }
        Object[] array = arrayListOf.toArray(new Group[arrayListOf.size()]);
        Intrinsics.checkNotNullExpressionValue(array, "groupList.toArray(arrayOfNulls(groupList.size))");
        return (Group[]) array;
    }

    private final Group Kh(final QUIListItemAdapter qUIListItemAdapter) {
        String c16;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        String string = getString(R.string.f1642825e);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.manage_minigame_download_file)");
        x.b.d dVar = new x.b.d(string);
        be beVar = this.storageSize;
        be beVar2 = null;
        if (beVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            beVar = null;
        }
        if (beVar.g() == 0 && NTScanSpaceManager.S().Y()) {
            c16 = getString(R.string.f1643125h);
        } else {
            be beVar3 = this.storageSize;
            if (beVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            } else {
                beVar2 = beVar3;
            }
            c16 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar2.g());
        }
        String str = c16;
        Intrinsics.checkNotNullExpressionValue(str, "if (storageSize.minigame\u2026ze)\n                    }");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.g(str, true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageManageFragment.Lh(QQStorageManageFragment.this, view);
            }
        });
        MutableLiveData<String> mutableLiveData = this.miniGameLiveData;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar, qUIListItemAdapter) { // from class: com.tencent.mobileqq.fragment.QQStorageManageFragment$createVAGameGroup$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> $this_apply;
            final /* synthetic */ QUIListItemAdapter $this_createVAGameGroup;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.$this_createVAGameGroup = qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) qUIListItemAdapter);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                this.$this_createVAGameGroup.l0(this.$this_apply);
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStorageManageFragment.Mh(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = xVar;
        return new Group(aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(QQStorageManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IMiniGameVAManager iMiniGameVAManager = (IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class);
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        iMiniGameVAManager.startMiniGameDownloadManagerActivity(requireActivity);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final Group Nh(final QUIListItemAdapter qUIListItemAdapter) {
        String c16;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        String string = getString(R.string.f1642925f);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.manage_zplan_download_file)");
        x.b.d dVar = new x.b.d(string);
        be beVar = this.storageSize;
        be beVar2 = null;
        if (beVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            beVar = null;
        }
        if (beVar.m() == 0) {
            c16 = getString(R.string.f1643125h);
        } else {
            be beVar3 = this.storageSize;
            if (beVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            } else {
                beVar2 = beVar3;
            }
            c16 = com.tencent.mobileqq.app.message.messageclean.q.c(beVar2.m());
        }
        String str = c16;
        Intrinsics.checkNotNullExpressionValue(str, "if (storageSize.zootopia\u2026ze)\n                    }");
        final com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.g(str, true, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStorageManageFragment.Oh(QQStorageManageFragment.this, view);
            }
        });
        MutableLiveData<String> mutableLiveData = this.zplanLiveData;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<String, Unit> function1 = new Function1<String, Unit>(xVar, qUIListItemAdapter) { // from class: com.tencent.mobileqq.fragment.QQStorageManageFragment$createZPlanGroup$1$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> $this_apply;
            final /* synthetic */ QUIListItemAdapter $this_createZPlanGroup;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_apply = xVar;
                this.$this_createZPlanGroup = qUIListItemAdapter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) xVar, (Object) qUIListItemAdapter);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                x.c.g O = this.$this_apply.O();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                O.h(it);
                this.$this_createZPlanGroup.l0(this.$this_apply);
            }
        };
        mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.fragment.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStorageManageFragment.Ph(Function1.this, obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = xVar;
        return new Group(aVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(QQStorageManageFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IZootopiaApi iZootopiaApi = (IZootopiaApi) QRoute.api(IZootopiaApi.class);
        FragmentActivity requireActivity = this$0.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        iZootopiaApi.startDownloadManagerActivity(requireActivity, ZootopiaSource.INSTANCE.a(Source.StorageScan));
        ReportController.y(this$0.app, "0X800C1B4");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Qh() {
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        if (nTScanSpaceManager.e0()) {
            Uh();
            Vh();
        }
    }

    private final void Rh() {
        Context context;
        QUISettingsRecyclerView qUISettingsRecyclerView;
        QUISettingsRecyclerView qUISettingsRecyclerView2;
        if (!needBlur() || this.quiSecNavBar == null || (context = getContext()) == null || (qUISettingsRecyclerView = this.recyclerView) == null) {
            return;
        }
        final int b16 = com.tencent.biz.qui.quisecnavbar.e.b(context);
        qUISettingsRecyclerView.setPadding(0, b16, 0, 0);
        qUISettingsRecyclerView.setClipToPadding(false);
        final boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar quiSecNavBar = this.quiSecNavBar;
        Intrinsics.checkNotNullExpressionValue(quiSecNavBar, "quiSecNavBar");
        if (isSettingPageNavNeedBlur) {
            qUISettingsRecyclerView2 = qUISettingsRecyclerView;
        } else {
            qUISettingsRecyclerView2 = null;
        }
        QUISecNavBar.setBlur$default(quiSecNavBar, isSettingPageNavNeedBlur, qUISettingsRecyclerView2, 0, 4, null);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        qUISettingsRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.fragment.n
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                QQStorageManageFragment.Sh(b16, isSettingPageNavNeedBlur, this, view, i3, i16, i17, i18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(int i3, boolean z16, QQStorageManageFragment this$0, View view, int i16, int i17, int i18, int i19) {
        float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i26 = i3 / 2;
        if (i17 <= 0) {
            f16 = 0.0f;
        } else if (i17 < i26) {
            f16 = (i17 * 1.0f) / i26;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            this$0.quiSecNavBar.setTitleBlurAlpha(f16);
        } else {
            this$0.quiSecNavBar.setTitleAlpha(f16);
        }
    }

    private final void Th() {
        if (this.miniGameOccupyListener != null) {
            return;
        }
        this.miniGameOccupyListener = new b();
        IMiniGameVAManager iMiniGameVAManager = (IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class);
        MiniGameSpaceOccupyListener miniGameSpaceOccupyListener = this.miniGameOccupyListener;
        Intrinsics.checkNotNull(miniGameSpaceOccupyListener);
        iMiniGameVAManager.registerMiniGameSpaceOccupyListener(miniGameSpaceOccupyListener);
    }

    private final void Uh() {
        if (this.zootopiaSpaceOccupyListener != null) {
            return;
        }
        this.zootopiaSpaceOccupyListener = new c();
        IZootopiaSpaceApi iZootopiaSpaceApi = (IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class);
        tb3.a aVar = this.zootopiaSpaceOccupyListener;
        Intrinsics.checkNotNull(aVar);
        iZootopiaSpaceApi.registerZootopiaSpaceOccupyListener(aVar);
    }

    private final void Vh() {
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).setZootopiaTaskDeleteListener(new d());
    }

    private final void Wh() {
        this.chatRecordListener = new NTScanSpaceManager.i() { // from class: com.tencent.mobileqq.fragment.w
            @Override // com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager.i
            public final void onUpdate() {
                QQStorageManageFragment.Xh(QQStorageManageFragment.this);
            }
        };
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        nTScanSpaceManager.E(this.chatRecordListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(QQStorageManageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.chatFileLiveData.setValue(Unit.INSTANCE);
    }

    private final void Yh() {
        MiniGameSpaceOccupyListener miniGameSpaceOccupyListener = this.miniGameOccupyListener;
        if (miniGameSpaceOccupyListener != null) {
            ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).unRegisterMiniGameSpaceOccupyListener(miniGameSpaceOccupyListener);
        }
        this.miniGameOccupyListener = null;
    }

    private final void Zh() {
        if (this.zootopiaSpaceOccupyListener == null) {
            return;
        }
        IZootopiaSpaceApi iZootopiaSpaceApi = (IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class);
        tb3.a aVar = this.zootopiaSpaceOccupyListener;
        Intrinsics.checkNotNull(aVar);
        iZootopiaSpaceApi.unRegisterZootopiaSpaceOccupyListener(aVar);
        this.zootopiaSpaceOccupyListener = null;
    }

    private final void ai() {
        ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).setZootopiaTaskDeleteListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.f228596u6));
        this.app = getBaseActivity().getAppInterface();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return R.layout.h58;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        be beVar = null;
        if (requestCode != 1001) {
            if (requestCode == 1002) {
                if (data != null) {
                    j16 = data.getLongExtra("extra_delete_total_file_size", 0L);
                } else {
                    j16 = 0;
                }
                if (j16 > 0) {
                    be beVar2 = this.storageSize;
                    if (beVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("storageSize");
                    } else {
                        beVar = beVar2;
                    }
                    beVar.n(j16);
                    this.chatFileLiveData.setValue(Unit.INSTANCE);
                    return;
                }
                return;
            }
            return;
        }
        if (data != null) {
            j3 = data.getLongExtra("extra_delete_total_file_size", 0L);
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            be beVar3 = this.storageSize;
            if (beVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            } else {
                beVar = beVar3;
            }
            beVar.o(j3);
            this.chatFileLiveData.setValue(Unit.INSTANCE);
        }
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroyView();
        Zh();
        ai();
        Yh();
        NTScanSpaceManager.i iVar = this.chatRecordListener;
        if (iVar != null) {
            NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
            if (nTScanSpaceManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager = null;
            }
            nTScanSpaceManager.t0(iVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onResume();
            ((IZootopiaSpaceApi) QRoute.api(IZootopiaSpaceApi.class)).calculateZootopiaSpaceOccupy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        NTScanSpaceManager S = NTScanSpaceManager.S();
        Intrinsics.checkNotNullExpressionValue(S, "getInstance()");
        this.scanSpaceManager = S;
        be beVar = null;
        if (S == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            S = null;
        }
        be V = S.V();
        Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
        this.storageSize = V;
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        this.recyclerView = qUISettingsRecyclerView;
        if (qUISettingsRecyclerView != null) {
            QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
            Group[] Jh = Jh(qUIListItemAdapter);
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Jh, Jh.length));
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        }
        Wh();
        Qh();
        Th();
        AppInterface appInterface = this.app;
        be beVar2 = this.storageSize;
        if (beVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            beVar2 = null;
        }
        String e16 = com.tencent.mobileqq.app.message.messageclean.q.e(beVar2.d());
        be beVar3 = this.storageSize;
        if (beVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
            beVar3 = null;
        }
        String e17 = com.tencent.mobileqq.app.message.messageclean.q.e(beVar3.c());
        be beVar4 = this.storageSize;
        if (beVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageSize");
        } else {
            beVar = beVar4;
        }
        ReportController.o(appInterface, "dc00898", "", "", "0X800C1B1", "0X800C1B1", 0, 0, e16, e17, com.tencent.mobileqq.app.message.messageclean.q.e(beVar.m()), "");
        Rh();
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
