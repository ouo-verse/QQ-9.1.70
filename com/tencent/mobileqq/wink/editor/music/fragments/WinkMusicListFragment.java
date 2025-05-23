package com.tencent.mobileqq.wink.editor.music.fragments;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListAdapter;
import com.tencent.mobileqq.wink.editor.music.ax;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicLyricEvent;
import com.tencent.mobileqq.wink.editor.music.event.WinkMusicRetryRecommendRequestEvent;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$musicBroadcastReceiver$2;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicRspResult;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.util.LoadingUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0002ijB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0003H\u0007J\b\u0010$\u001a\u00020\u0003H\u0016J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%J\u0006\u0010(\u001a\u00020\u0018J\u000e\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020!R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020C8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010IR\u0016\u0010+\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010RR\"\u0010X\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010I\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010?\u001a\u0004\b[\u0010\\R\u001b\u0010`\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010?\u001a\u0004\b_\u0010\\R#\u0010e\u001a\n a*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010?\u001a\u0004\bc\u0010d\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment;", "Landroidx/fragment/app/Fragment;", "Lb73/a;", "", "initViewModel", "Ph", "Lh", "Kh", "Mh", "Landroid/view/View;", "view", "initView", "", "Jh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "selectedMusicInfo", "", "position", "J0", "enableMusicCut", "M", "musicInfo", "z5", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "oc", "Oh", "onDestroyView", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "type", "Rh", "Ah", "canCancelMusic", "Qh", "pgId", "Sh", "Landroidx/lifecycle/ViewModelStoreOwner;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/ViewModelStoreOwner;", "mStoreOwner", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListAdapter;", "D", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/FrameLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/FrameLayout;", "contentView", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "G", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Landroid/content/BroadcastReceiver;", "H", "Ch", "()Landroid/content/BroadcastReceiver;", "musicBroadcastReceiver", "I", "Z", "mEnableMusicClear", "J", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "fragmentScene", "K", "currentTabScene", "L", "isCanCancelMusic", "Ljava/lang/String;", "N", OcrConfig.CHINESE, "()Z", "setExpand", "(Z)V", "expand", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "P", "Eh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "noNetState", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "yh", "emptyState", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Req, "Bh", "()Landroid/view/View;", "loadingState", "<init>", "()V", "T", "a", "MusicRequestType", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicListFragment extends ReportAndroidXFragment implements b73.a {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ViewModelStoreOwner mStoreOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private WinkMusicListAdapter adapter;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private FrameLayout contentView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicBroadcastReceiver;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mEnableMusicClear;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MusicRequestType fragmentScene;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private MusicRequestType currentTabScene;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isCanCancelMusic;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String pgId;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean expand;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy noNetState;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyState;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingState;

    @NotNull
    public Map<Integer, View> S = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "", "(Ljava/lang/String;I)V", "COLLECTION", DrivingResultObject.RECOMMEND, "DAILY_SIGN", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum MusicRequestType {
        COLLECTION,
        RECOMMEND,
        DAILY_SIGN
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$a;", "", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$MusicRequestType;", "scene", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "Lcom/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment;", "a", "", "KEY_TYPE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkMusicListFragment a(@NotNull MusicRequestType scene, @Nullable ViewModelStoreOwner storeOwner) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            WinkMusicListFragment winkMusicListFragment = new WinkMusicListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("music_request_type", scene);
            winkMusicListFragment.setArguments(bundle);
            winkMusicListFragment.mStoreOwner = storeOwner;
            return winkMusicListFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f320811a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f320812b;

        static {
            int[] iArr = new int[MusicRspResult.Result.values().length];
            try {
                iArr[MusicRspResult.Result.NO_NET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicRspResult.Result.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MusicRspResult.Result.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f320811a = iArr;
            int[] iArr2 = new int[MusicRequestType.values().length];
            try {
                iArr2[MusicRequestType.COLLECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MusicRequestType.RECOMMEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MusicRequestType.DAILY_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f320812b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/WinkMusicListFragment$d", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements MusicSourceViewModel.c {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.c
        public void a(@NotNull WinkEditorMusicInfo musicInfo) {
            Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
            Intent intent = new Intent();
            intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
            intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_PLAY_MEDIA_CACHE_MUSIC_SUCCESS);
            intent.putExtra("cacheMusicMid", musicInfo.p());
            FragmentActivity activity = WinkMusicListFragment.this.getActivity();
            if (activity != null) {
                activity.sendBroadcast(intent);
            }
        }
    }

    public WinkMusicListFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModelStoreOwner viewModelStoreOwner;
                viewModelStoreOwner = WinkMusicListFragment.this.mStoreOwner;
                if (viewModelStoreOwner == null) {
                    viewModelStoreOwner = WinkMusicListFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(viewModelStoreOwner, "requireActivity()");
                }
                ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mStore\u2026rceViewModel::class.java]");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMusicListFragment$musicBroadcastReceiver$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$musicBroadcastReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$musicBroadcastReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final WinkMusicListFragment winkMusicListFragment = WinkMusicListFragment.this;
                return new BroadcastReceiver() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$musicBroadcastReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                        MusicSourceViewModel Dh;
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (WinkMusicListFragment.this.getExpand()) {
                            Dh = WinkMusicListFragment.this.Dh();
                            Dh.Q3(context, intent);
                        }
                    }
                };
            }
        });
        this.musicBroadcastReceiver = lazy2;
        this.mEnableMusicClear = true;
        MusicRequestType musicRequestType = MusicRequestType.RECOMMEND;
        this.fragmentScene = musicRequestType;
        this.currentTabScene = musicRequestType;
        this.isCanCancelMusic = true;
        this.pgId = WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE;
        this.expand = true;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$noNetState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                QUIEmptyState.Builder builder = new QUIEmptyState.Builder(WinkMusicListFragment.this.getContext());
                builder.setTitle("\u7f51\u7edc\u672a\u8fde\u63a5\uff0c\u8bf7\u70b9\u51fb\u91cd\u8bd5");
                builder.setImageType(5);
                builder.setBackgroundColorType(0);
                builder.setThemeType(2);
                builder.setHalfScreenState(true);
                return builder.build();
            }
        });
        this.noNetState = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$emptyState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                WinkMusicListFragment.MusicRequestType musicRequestType2;
                String str;
                WinkMusicListFragment.MusicRequestType musicRequestType3;
                QUIEmptyState.Builder builder = new QUIEmptyState.Builder(WinkMusicListFragment.this.getContext());
                WinkMusicListFragment winkMusicListFragment = WinkMusicListFragment.this;
                musicRequestType2 = winkMusicListFragment.fragmentScene;
                if (musicRequestType2 != WinkMusicListFragment.MusicRequestType.RECOMMEND) {
                    musicRequestType3 = winkMusicListFragment.fragmentScene;
                    if (musicRequestType3 != WinkMusicListFragment.MusicRequestType.DAILY_SIGN) {
                        str = "\u6536\u85cf";
                        builder.setTitle("\u6682\u65e0QQ\u97f3\u4e50" + str + "\u6b4c\u66f2");
                        builder.setImageType(16);
                        builder.setBackgroundColorType(0);
                        builder.setThemeType(2);
                        builder.setHalfScreenState(true);
                        return builder.build();
                    }
                }
                str = "\u63a8\u8350";
                builder.setTitle("\u6682\u65e0QQ\u97f3\u4e50" + str + "\u6b4c\u66f2");
                builder.setImageType(16);
                builder.setBackgroundColorType(0);
                builder.setThemeType(2);
                builder.setHalfScreenState(true);
                return builder.build();
            }
        });
        this.emptyState = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.WinkMusicListFragment$loadingState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View inflate = LayoutInflater.from(WinkMusicListFragment.this.getContext()).inflate(R.layout.i5f, (ViewGroup) null, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.zk7);
                imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(imageView.getContext(), 2));
                return inflate;
            }
        });
        this.loadingState = lazy5;
    }

    private final View Bh() {
        return (View) this.loadingState.getValue();
    }

    private final BroadcastReceiver Ch() {
        return (BroadcastReceiver) this.musicBroadcastReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicSourceViewModel Dh() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    private final QUIEmptyState Eh() {
        return (QUIEmptyState) this.noNetState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(WinkMusicListFragment this$0, List list) {
        boolean areEqual;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Jh() && list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) obj;
                if (this$0.fragmentScene == MusicRequestType.RECOMMEND) {
                    areEqual = Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_RECOMMEND_ID");
                } else {
                    areEqual = Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_COLLECTION_ID");
                }
                if (areEqual) {
                    arrayList.add(obj);
                }
            }
            Object obj2 = null;
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                w53.b.f("WinkMusicListFragment", "[observe] musicList list size:" + arrayList.size() + " scene:" + this$0.fragmentScene);
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((WinkEditorMusicInfo) next).f321259e) {
                        obj2 = next;
                        break;
                    }
                }
                WinkEditorMusicInfo winkEditorMusicInfo2 = (WinkEditorMusicInfo) obj2;
                if (winkEditorMusicInfo2 != null) {
                    this$0.Dh().J4(winkEditorMusicInfo2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(WinkMusicListFragment this$0, HashMap hashMap) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.Jh()) {
            return;
        }
        MusicRequestType musicRequestType = this$0.fragmentScene;
        w53.b.f("WinkMusicListFragment", "[observe] scene:" + musicRequestType + " rspResultLiveData:" + hashMap.get(musicRequestType));
        MusicRspResult musicRspResult = (MusicRspResult) hashMap.get(this$0.fragmentScene);
        if (musicRspResult != null) {
            int i3 = b.f320811a[musicRspResult.getResult().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    this$0.Lh();
                }
            } else {
                this$0.Mh();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.Mh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(WinkMusicListFragment this$0, Integer num) {
        int intValue;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Jh() && this$0.adapter != null && num != null) {
            num.intValue();
            RecyclerView recyclerView = null;
            if (num.intValue() < 0) {
                intValue = 0;
            } else {
                int intValue2 = num.intValue();
                WinkMusicListAdapter winkMusicListAdapter = this$0.adapter;
                if (winkMusicListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    winkMusicListAdapter = null;
                }
                if (intValue2 >= winkMusicListAdapter.getItemCount()) {
                    WinkMusicListAdapter winkMusicListAdapter2 = this$0.adapter;
                    if (winkMusicListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        winkMusicListAdapter2 = null;
                    }
                    intValue = winkMusicListAdapter2.getItemCount() - 1;
                } else {
                    intValue = num.intValue();
                }
            }
            w53.b.f("WinkMusicListFragment", "[observe] musicPos:" + intValue);
            RecyclerView recyclerView2 = this$0.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.smoothScrollToPosition(intValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(WinkMusicListFragment this$0, List list) {
        MusicRspResult musicRspResult;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicRspResult musicRspResult2 = null;
        RecyclerView recyclerView = null;
        RecyclerView recyclerView2 = null;
        if (!this$0.Jh()) {
            RecyclerView recyclerView3 = this$0.recyclerView;
            if (recyclerView3 != null) {
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.setNestedScrollingEnabled(false);
                return;
            }
            return;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) obj;
                MusicRequestType musicRequestType = this$0.fragmentScene;
                if (musicRequestType == MusicRequestType.RECOMMEND) {
                    z16 = Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_RECOMMEND_ID");
                } else if (musicRequestType == MusicRequestType.COLLECTION) {
                    z16 = Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_COLLECTION_ID");
                } else if (musicRequestType == MusicRequestType.DAILY_SIGN) {
                    z16 = Intrinsics.areEqual(winkEditorMusicInfo.D, "FAKE_CATEGORY_DAILY_SIGN_ID");
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            if (!(!arrayList.isEmpty())) {
                arrayList = null;
            }
            if (arrayList != null) {
                w53.b.f("WinkMusicListFragment", "[observe] curMusicList list size:" + arrayList.size() + " scene:" + this$0.fragmentScene);
                WinkMusicListAdapter winkMusicListAdapter = this$0.adapter;
                if (winkMusicListAdapter != null) {
                    if (winkMusicListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        winkMusicListAdapter = null;
                    }
                    winkMusicListAdapter.updateData(arrayList);
                    WinkMusicListAdapter winkMusicListAdapter2 = this$0.adapter;
                    if (winkMusicListAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        winkMusicListAdapter2 = null;
                    }
                    winkMusicListAdapter2.notifyDataSetChanged();
                } else {
                    this$0.adapter = new WinkMusicListAdapter(arrayList, this$0);
                    RecyclerView recyclerView4 = this$0.recyclerView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView4 = null;
                    }
                    recyclerView4.setLayoutManager(new LinearLayoutManager(this$0.getContext()));
                    RecyclerView recyclerView5 = this$0.recyclerView;
                    if (recyclerView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView5 = null;
                    }
                    WinkMusicListAdapter winkMusicListAdapter3 = this$0.adapter;
                    if (winkMusicListAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        winkMusicListAdapter3 = null;
                    }
                    recyclerView5.setAdapter(winkMusicListAdapter3);
                    RecyclerView recyclerView6 = this$0.recyclerView;
                    if (recyclerView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView6 = null;
                    }
                    recyclerView6.addOnScrollListener(new c());
                }
                FrameLayout frameLayout = this$0.contentView;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentView");
                    frameLayout = null;
                }
                frameLayout.setVisibility(8);
                RecyclerView recyclerView7 = this$0.recyclerView;
                if (recyclerView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView7 = null;
                }
                recyclerView7.setVisibility(0);
                RecyclerView recyclerView8 = this$0.recyclerView;
                if (recyclerView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView8 = null;
                }
                recyclerView8.setNestedScrollingEnabled(true);
                RecyclerView recyclerView9 = this$0.recyclerView;
                if (recyclerView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView2 = recyclerView9;
                }
                VideoReport.traversePage(recyclerView2);
                return;
            }
        }
        MusicRequestType musicRequestType2 = this$0.fragmentScene;
        HashMap<MusicRequestType, MusicRspResult> value = this$0.Dh().s3().getValue();
        if (value != null) {
            musicRspResult2 = value.get(this$0.fragmentScene);
        }
        w53.b.f("WinkMusicListFragment", "[observe] loadEmptyView scene:" + musicRequestType2 + " rsp:" + musicRspResult2);
        HashMap<MusicRequestType, MusicRspResult> value2 = this$0.Dh().s3().getValue();
        if (value2 != null && (musicRspResult = value2.get(this$0.fragmentScene)) != null) {
            int i3 = b.f320811a[musicRspResult.getResult().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this$0.Kh();
                        return;
                    }
                    return;
                }
                this$0.Lh();
                return;
            }
            this$0.Mh();
        }
    }

    private final boolean Jh() {
        if (this.currentTabScene == this.fragmentScene) {
            return true;
        }
        return false;
    }

    private final void Kh() {
        FrameLayout frameLayout = this.contentView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.contentView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout3 = null;
        }
        frameLayout3.addView(yh(), new ViewGroup.LayoutParams(-1, -1));
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        FrameLayout frameLayout4 = this.contentView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.setVisibility(0);
    }

    private final void Lh() {
        w53.b.a("WinkMusicListFragment", "loadLoadingView... scene:" + this.fragmentScene);
        FrameLayout frameLayout = this.contentView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.contentView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout3 = null;
        }
        frameLayout3.addView(Bh(), new ViewGroup.LayoutParams(-1, -1));
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        FrameLayout frameLayout4 = this.contentView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.setVisibility(0);
    }

    private final void Mh() {
        w53.b.f("WinkMusicListFragment", "loadNoNetView... scene:" + this.fragmentScene);
        FrameLayout frameLayout = this.contentView;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout = null;
        }
        frameLayout.removeAllViews();
        FrameLayout frameLayout3 = this.contentView;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            frameLayout3 = null;
        }
        frameLayout3.addView(Eh(), new ViewGroup.LayoutParams(-1, -1));
        Eh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMusicListFragment.Nh(WinkMusicListFragment.this, view);
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setVisibility(8);
        FrameLayout frameLayout4 = this.contentView;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(WinkMusicListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh().r4(this$0.fragmentScene);
        int i3 = b.f320812b[this$0.fragmentScene.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    SimpleEventBus.getInstance().dispatchEvent(new WinkMusicRetryRecommendRequestEvent());
                }
            } else {
                SimpleEventBus.getInstance().dispatchEvent(new WinkMusicRetryRecommendRequestEvent());
            }
        } else {
            this$0.Dh().E3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ph() {
        IntentFilter intentFilter = new IntentFilter(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(Ch(), intentFilter);
        }
        Dh().A4(new d());
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f123717he);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.wink_music_list_rv)");
        this.recyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.f371416g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.qfs_empty_status_hint_view)");
        this.contentView = (FrameLayout) findViewById2;
    }

    private final void initViewModel() {
        Dh().N2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicListFragment.Ih(WinkMusicListFragment.this, (List) obj);
            }
        });
        Dh().j3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicListFragment.Fh(WinkMusicListFragment.this, (List) obj);
            }
        });
        Dh().s3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicListFragment.Gh(WinkMusicListFragment.this, (HashMap) obj);
            }
        });
        Dh().l3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMusicListFragment.Hh(WinkMusicListFragment.this, (Integer) obj);
            }
        });
    }

    private final QUIEmptyState yh() {
        return (QUIEmptyState) this.emptyState.getValue();
    }

    @Override // b73.a
    @NotNull
    public WinkEditorViewModel.EditMode A() {
        return Dh().getEditMode();
    }

    public final int Ah() {
        RecyclerView recyclerView = this.recyclerView;
        LinearLayoutManager linearLayoutManager = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
        if (linearLayoutManager != null) {
            return linearLayoutManager.findFirstVisibleItemPosition();
        }
        return 0;
    }

    @Override // b73.a
    public void J0(@Nullable WinkEditorMusicInfo selectedMusicInfo, int position) {
        if (selectedMusicInfo != null && !selectedMusicInfo.y()) {
            if (selectedMusicInfo.f321259e) {
                if (Dh().getEditMode() != WinkEditorViewModel.EditMode.Image && this.isCanCancelMusic) {
                    Dh().y2();
                } else {
                    QQToast.makeText(getContext(), 0, "\u4e0d\u652f\u6301\u53d6\u6d88\u97f3\u4e50", 0).show();
                }
            } else {
                Dh().M3(selectedMusicInfo, position);
            }
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, 0);
        }
    }

    @Override // b73.a
    public void M(boolean enableMusicCut) {
        WinkEditorMusicInfo currentMusic = Dh().getCurrentMusic();
        if (currentMusic != null) {
            MusicSourceViewModel Dh = Dh();
            String p16 = currentMusic.p();
            Intrinsics.checkNotNullExpressionValue(p16, "it.getSongMid()");
            SimpleEventBus.getInstance().dispatchEvent(new WinkMusicLyricEvent(currentMusic, Dh.m3(p16), Dh().getVideoDurationMs(), true));
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void Oh() {
        if (this.adapter != null) {
            w53.b.f("WinkMusicListFragment", "notifyAdapterChanged scene:" + this.fragmentScene);
            WinkMusicListAdapter winkMusicListAdapter = this.adapter;
            if (winkMusicListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                winkMusicListAdapter = null;
            }
            winkMusicListAdapter.notifyDataSetChanged();
        }
    }

    public final void Qh(boolean canCancelMusic) {
        this.isCanCancelMusic = canCancelMusic;
    }

    public final void Rh(@NotNull MusicRequestType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.currentTabScene = type;
    }

    public final void Sh(@NotNull String pgId) {
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        this.pgId = pgId;
    }

    public void _$_clearFindViewByIdCache() {
        this.S.clear();
    }

    @Override // b73.a
    @NotNull
    /* renamed from: oc, reason: from getter */
    public String getPgId() {
        return this.pgId;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hdr, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        w53.b.f("WinkMusicListFragment", "onDestroyView scene:" + this.fragmentScene);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(Ch());
        }
        Dh().A4(null);
        ax.f320779f.d();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Serializable serializable;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        MusicRequestType musicRequestType = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("music_request_type");
        } else {
            serializable = null;
        }
        if (serializable instanceof MusicRequestType) {
            musicRequestType = (MusicRequestType) serializable;
        }
        if (musicRequestType == null) {
            musicRequestType = MusicRequestType.RECOMMEND;
        }
        this.fragmentScene = musicRequestType;
        w53.b.f("WinkMusicListFragment", "onViewCreated... scene:" + musicRequestType);
        initView(view);
        Dh().r4(this.fragmentScene);
        initViewModel();
        Ph();
    }

    @Override // b73.a
    public void z5(@NotNull WinkEditorMusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        Dh().J3(musicInfo);
    }

    /* renamed from: zh, reason: from getter */
    public final boolean getExpand() {
        return this.expand;
    }
}
