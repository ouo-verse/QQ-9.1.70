package com.tencent.qqnt.qbasealbum.album.viewmodel;

import android.content.Intent;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository;
import com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel;
import com.tencent.qqnt.qbasealbum.base.repository.b;
import com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.datahub.m;
import com.tencent.qqnt.qbasealbum.datahub.n;
import com.tencent.qqnt.qbasealbum.datahub.o;
import com.tencent.qqnt.qbasealbum.datahub.p;
import com.tencent.qqnt.qbasealbum.datahub.q;
import com.tencent.qqnt.qbasealbum.datahub.r;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.qqnt.qbasealbum.select.viewmodel.SelectedMediaViewModel;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0002opB\u000f\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\bl\u0010mJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JR\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0012H\u0002JJ\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00122\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0015H\u0002JJ\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00152\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005H\u0002JR\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00182\u001e\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t2\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u001bH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010#\u001a\u00020\"H\u0002J\u000e\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+J\u0014\u00101\u001a\u00020\u00072\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.J\u0016\u00103\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u0002022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u00104\u001a\u00020\nH\u0016J\"\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f2\u0006\u00106\u001a\u000205H\u0014J\"\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f2\u0006\u00106\u001a\u000205H\u0016J\u0016\u0010;\u001a\u00020\u00072\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\r09H\u0016J\u0012\u0010=\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\b\u0010?\u001a\u00020\u0007H\u0014J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0017R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR \u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR,\u0010S\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR,\u0010U\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010RR,\u0010W\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010RR&\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR&\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010YR&\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010YR\u0016\u0010a\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\"\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020)0\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010RR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\n0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020\n0.8\u0006\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\u00a8\u0006q"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel;", "Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;", "Lcom/tencent/qqnt/qbasealbum/base/repository/b$b;", "Lcom/tencent/qqnt/qbasealbum/datahub/p;", "event", "Lcom/tencent/qqnt/qbasealbum/select/viewmodel/SelectedMediaViewModel;", "selectedMediaViewModel", "", "B2", "", "", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "uiStateData", "Landroidx/lifecycle/MediatorLiveData;", "liveData", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/qqnt/qbasealbum/datahub/o;", NowProxyConstants.AccountInfoKey.A2, "r2", "Lcom/tencent/qqnt/qbasealbum/datahub/m;", "y2", "p2", "Lcom/tencent/qqnt/qbasealbum/datahub/n;", "z2", "q2", "Lcom/tencent/qqnt/qbasealbum/datahub/q;", "C2", "Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel$b;", Constants.BASE_IN_PLUGIN_VERSION, "info", "", "o2", "Lcom/tencent/qqnt/qbasealbum/base/repository/a;", "mediaRepoData", "H2", "J2", "F2", "E2", "w2", "", "t2", "Landroid/content/Intent;", "intent", "setIntent", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/qqnt/qbasealbum/model/b;", "curSelectedAlbumId", "x2", "Lcom/tencent/qqnt/qbasealbum/datahub/a;", "v2", "getLogTag", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "W1", "u2", "", "selectedMedia", "onMediaInit", "albumId", "switchAlbum", "fetchFirstPageMedia", "onCleared", "j0", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "Lcom/tencent/qqnt/qbasealbum/album/repository/PickerLocalMediaRepository;", "G", "Lcom/tencent/qqnt/qbasealbum/album/repository/PickerLocalMediaRepository;", "localMediaRepository", "H", "Ljava/lang/String;", "currentAlbumId", "I", "Z", "isAlbumChangeObserved", "Ljava/util/concurrent/ConcurrentHashMap;", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "albumIdToLoadingStatus", "K", "Ljava/util/Map;", "albumIdToMediaUIStateData", "L", "albumIdToVideosUIStateData", "M", "albumIdToImagesUIStateData", "N", "Landroidx/lifecycle/MediatorLiveData;", "mediaMediatorLiveData", "P", "videosMediatorLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "imagesMediatorLiveData", BdhLogUtil.LogTag.Tag_Req, "Landroid/content/Intent;", "hostFragmentIntent", ExifInterface.LATITUDE_SOUTH, "lastSeq", "Landroidx/lifecycle/MutableLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "_isFirstFetchDoneLiveData", "U", "Landroidx/lifecycle/LiveData;", "isFirstFetchDoneLiveData", "()Landroidx/lifecycle/LiveData;", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/PageType;)V", "V", "a", "b", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerLocalMediaViewModel extends PickerBaseViewModel implements b.InterfaceC9681b {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final PageType pageType;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final PickerLocalMediaRepository localMediaRepository;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String currentAlbumId;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isAlbumChangeObserved;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, b> albumIdToLoadingStatus;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToMediaUIStateData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToVideosUIStateData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToImagesUIStateData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaMediatorLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> videosMediatorLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> imagesMediatorLiveData;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private Intent hostFragmentIntent;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Map<String, Long> lastSeq;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _isFirstFetchDoneLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> isFirstFetchDoneLiveData;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel$a;", "", "", "FETCH_SEQ_KEY", "Ljava/lang/String;", "FIRST_PAGE_KEY", "", "FIRST_PAGE_MEDIA_SIZE", "I", "FIRST_QUERY_DONE_EMPTY", "FIRST_QUERY_DONE_FAILURE", "FIRST_QUERY_DONE_NO_PERMISSION", "FIRST_QUERY_DONE_SUCCESS", "MEDIA_SIZE_MOST_LEFT", "NEXT_PAGE_MEDIA_SIZE", "TAG", "TIMES_OF_QUERY", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$a, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360834a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32599);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[PageType.values().length];
            try {
                iArr[PageType.LOCAL_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageType.LOCAL_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageType.LOCAL_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f360834a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32629);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PickerLocalMediaViewModel(@NotNull PageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pageType);
            return;
        }
        this.pageType = pageType;
        PickerLocalMediaRepository pickerLocalMediaRepository = new PickerLocalMediaRepository(pageType);
        this.localMediaRepository = pickerLocalMediaRepository;
        this.currentAlbumId = com.tencent.qqnt.qbasealbum.model.a.f361348a.a();
        this.albumIdToLoadingStatus = new ConcurrentHashMap<>();
        this.albumIdToMediaUIStateData = new LinkedHashMap();
        this.albumIdToVideosUIStateData = new LinkedHashMap();
        this.albumIdToImagesUIStateData = new LinkedHashMap();
        this.mediaMediatorLiveData = new MediatorLiveData<>();
        this.videosMediatorLiveData = new MediatorLiveData<>();
        this.imagesMediatorLiveData = new MediatorLiveData<>();
        this.hostFragmentIntent = new Intent();
        this.lastSeq = new LinkedHashMap();
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._isFirstFetchDoneLiveData = mutableLiveData;
        this.isFirstFetchDoneLiveData = mutableLiveData;
        pickerLocalMediaRepository.mediaQueryListener = this;
    }

    private final void A2(o event) {
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 || !com.tencent.qqnt.qbasealbum.ktx.b.o(event.b())) {
                    return;
                }
                r2(event, this.albumIdToVideosUIStateData, this.videosMediatorLiveData);
                return;
            }
            r2(event, this.albumIdToMediaUIStateData, this.mediaMediatorLiveData);
            return;
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(event.b())) {
            return;
        }
        r2(event, this.albumIdToImagesUIStateData, this.imagesMediatorLiveData);
    }

    private final void B2(p event, SelectedMediaViewModel selectedMediaViewModel) {
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 || !com.tencent.qqnt.qbasealbum.ktx.b.o(event.a())) {
                    return;
                }
                s2(event, selectedMediaViewModel, this.albumIdToVideosUIStateData, this.videosMediatorLiveData);
                return;
            }
            s2(event, selectedMediaViewModel, this.albumIdToMediaUIStateData, this.mediaMediatorLiveData);
            return;
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(event.a())) {
            return;
        }
        s2(event, selectedMediaViewModel, this.albumIdToImagesUIStateData, this.imagesMediatorLiveData);
    }

    private final void C2(q event) {
        UIStateData<List<LocalMediaInfo>> uIStateData;
        UIStateData<List<LocalMediaInfo>> uIStateData2;
        if (!o2(event.a())) {
            return;
        }
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 && com.tencent.qqnt.qbasealbum.ktx.b.o(event.a()) && (uIStateData2 = this.albumIdToVideosUIStateData.get(this.currentAlbumId)) != null) {
                    this.videosMediatorLiveData.postValue(uIStateData2);
                    return;
                }
                return;
            }
            UIStateData<List<LocalMediaInfo>> uIStateData3 = this.albumIdToMediaUIStateData.get(this.currentAlbumId);
            if (uIStateData3 != null) {
                this.mediaMediatorLiveData.postValue(uIStateData3);
                return;
            }
            return;
        }
        if (!com.tencent.qqnt.qbasealbum.ktx.b.o(event.a()) && (uIStateData = this.albumIdToImagesUIStateData.get(this.currentAlbumId)) != null) {
            this.imagesMediatorLiveData.postValue(uIStateData);
        }
    }

    private final b D2() {
        Map<String, ? extends Object> mapOf;
        final b bVar = this.albumIdToLoadingStatus.get(this.currentAlbumId);
        if (bVar != null) {
            ox3.a.a("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$onMediaTraversalDone$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.b.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "media traversal done trigger media query needLoadMore: " + PickerLocalMediaViewModel.b.this.a() + ", isQuerying: " + PickerLocalMediaViewModel.b.this.c();
                }
            });
            if (bVar.a() && !bVar.c()) {
                bVar.e(true);
                bVar.f(bVar.b() + 1);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("timesOfQuery", Integer.valueOf(bVar.b())), TuplesKt.to("fetchSeqKey", new HashMap(this.lastSeq)));
                this.localMediaRepository.b(this.currentAlbumId, 600, mapOf);
                return bVar;
            }
            return bVar;
        }
        return null;
    }

    private final void E2(com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        String str;
        MutableLiveData<String> mutableLiveData = this._isFirstFetchDoneLiveData;
        if (mediaRepoData.f()) {
            if (mediaRepoData.c().isEmpty()) {
                str = "-20002";
            } else {
                str = "0";
            }
        } else {
            str = "-20001";
        }
        mutableLiveData.postValue(str);
    }

    private final void F2(final com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.b
            @Override // java.lang.Runnable
            public final void run() {
                PickerLocalMediaViewModel.G2(PickerLocalMediaViewModel.this, mediaRepoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G2(final PickerLocalMediaViewModel this$0, com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaRepoData, "$mediaRepoData");
        PageType pageType = this$0.pageType;
        if (pageType != PageType.LOCAL_ALL && pageType != PageType.LOCAL_IMAGE) {
            return;
        }
        final UIStateData<List<LocalMediaInfo>> X1 = this$0.X1(this$0.albumIdToImagesUIStateData, mediaRepoData);
        List<LocalMediaInfo> data = X1.getData();
        List<LocalMediaInfo> c16 = mediaRepoData.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.n((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        data.addAll(arrayList);
        if (Intrinsics.areEqual(mediaRepoData.a(), this$0.currentAlbumId)) {
            this$0.imagesMediatorLiveData.postValue(X1);
        }
        if (!mediaRepoData.b()) {
            ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>(X1) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$updateImagesUIStateLiveData$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ UIStateData<List<LocalMediaInfo>> $imagesUIStateData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$imagesUIStateData = X1;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this, (Object) X1);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    str = PickerLocalMediaViewModel.this.currentAlbumId;
                    return "query images end: currentAlbumId=" + str + ", size=" + this.$imagesUIStateData.getData().size();
                }
            });
        }
    }

    private final void H2(final com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.d
            @Override // java.lang.Runnable
            public final void run() {
                PickerLocalMediaViewModel.I2(PickerLocalMediaViewModel.this, mediaRepoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(final PickerLocalMediaViewModel this$0, com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaRepoData, "$mediaRepoData");
        if (this$0.pageType != PageType.LOCAL_ALL) {
            return;
        }
        final UIStateData<List<LocalMediaInfo>> X1 = this$0.X1(this$0.albumIdToMediaUIStateData, mediaRepoData);
        List<LocalMediaInfo> data = X1.getData();
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mediaRepoData.c());
        data.addAll(filterNotNull);
        if (Intrinsics.areEqual(mediaRepoData.a(), this$0.currentAlbumId)) {
            this$0.mediaMediatorLiveData.postValue(X1);
        }
        if (!mediaRepoData.b()) {
            ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>(X1) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$updateMediaUIStateLiveData$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ UIStateData<List<LocalMediaInfo>> $mediaUIStateData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$mediaUIStateData = X1;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this, (Object) X1);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    str = PickerLocalMediaViewModel.this.currentAlbumId;
                    return "query media end: currentAlbumId=" + str + ", size=" + this.$mediaUIStateData.getData().size();
                }
            });
        }
    }

    private final void J2(final com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                PickerLocalMediaViewModel.K2(PickerLocalMediaViewModel.this, mediaRepoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K2(final PickerLocalMediaViewModel this$0, com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaRepoData, "$mediaRepoData");
        PageType pageType = this$0.pageType;
        if (pageType != PageType.LOCAL_ALL && pageType != PageType.LOCAL_VIDEO) {
            return;
        }
        final UIStateData<List<LocalMediaInfo>> X1 = this$0.X1(this$0.albumIdToVideosUIStateData, mediaRepoData);
        List<LocalMediaInfo> data = X1.getData();
        List<LocalMediaInfo> c16 = mediaRepoData.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : c16) {
            if (com.tencent.qqnt.qbasealbum.ktx.b.o((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        data.addAll(arrayList);
        if (Intrinsics.areEqual(mediaRepoData.a(), this$0.currentAlbumId)) {
            this$0.videosMediatorLiveData.postValue(X1);
        }
        if (!mediaRepoData.b()) {
            ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>(X1) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$updateVideosUIStateLiveData$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ UIStateData<List<LocalMediaInfo>> $videosUIStateData;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$videosUIStateData = X1;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this, (Object) X1);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    str = PickerLocalMediaViewModel.this.currentAlbumId;
                    return "query videos end: currentAlbumId=" + str + ", size=" + this.$videosUIStateData.getData().size();
                }
            });
        }
    }

    private final boolean o2(LocalMediaInfo info) {
        String str = this.currentAlbumId;
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        if (!Intrinsics.areEqual(str, aVar.a()) && !Intrinsics.areEqual(this.currentAlbumId, com.tencent.qqnt.qbasealbum.ktx.b.c(info)) && (!Intrinsics.areEqual(this.currentAlbumId, aVar.b()) || !com.tencent.qqnt.qbasealbum.ktx.b.o(info))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAlbumChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void p2(m event, Map<String, UIStateData<List<LocalMediaInfo>>> uiStateData, MediatorLiveData<UIStateData<List<LocalMediaInfo>>> liveData) {
        boolean z16;
        UIStateData<List<LocalMediaInfo>> uIStateData;
        List<LocalMediaInfo> data;
        UIStateData<List<LocalMediaInfo>> uIStateData2;
        List<LocalMediaInfo> data2;
        UIStateData<List<LocalMediaInfo>> uIStateData3 = uiStateData.get(event.d());
        boolean z17 = true;
        if (uIStateData3 != null && (data2 = uIStateData3.getData()) != null && data2.contains(event.b())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            uIStateData3.getData().remove(event.b());
            if (Intrinsics.areEqual(this.currentAlbumId, event.d()) && (uIStateData2 = uiStateData.get(this.currentAlbumId)) != null) {
                liveData.postValue(uIStateData2);
            }
        }
        UIStateData<List<LocalMediaInfo>> uIStateData4 = uiStateData.get(event.c());
        if (uIStateData4 == null || (data = uIStateData4.getData()) == null || data.contains(event.b())) {
            z17 = false;
        }
        if (z17) {
            uIStateData4.getData().add(event.a(), event.b());
            if (o2(event.b()) && (uIStateData = uiStateData.get(this.currentAlbumId)) != null) {
                liveData.postValue(uIStateData);
            }
        }
    }

    private final void q2(n event, Map<String, UIStateData<List<LocalMediaInfo>>> uiStateData, MediatorLiveData<UIStateData<List<LocalMediaInfo>>> liveData, SelectedMediaViewModel selectedMediaViewModel) {
        UIStateData<List<LocalMediaInfo>> uIStateData;
        boolean z16;
        List<LocalMediaInfo> data;
        boolean z17;
        List<LocalMediaInfo> data2;
        List<LocalMediaInfo> data3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (LocalMediaInfo localMediaInfo : event.a()) {
            com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
            UIStateData<List<LocalMediaInfo>> uIStateData2 = uiStateData.get(aVar.a());
            boolean z18 = false;
            if (uIStateData2 != null && (data3 = uIStateData2.getData()) != null && data3.remove(localMediaInfo)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashSet.add(aVar.a());
            }
            if (com.tencent.qqnt.qbasealbum.ktx.b.o(localMediaInfo)) {
                UIStateData<List<LocalMediaInfo>> uIStateData3 = uiStateData.get(aVar.b());
                if (uIStateData3 != null && (data2 = uIStateData3.getData()) != null && data2.remove(localMediaInfo)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    linkedHashSet.add(aVar.b());
                }
            }
            UIStateData<List<LocalMediaInfo>> uIStateData4 = uiStateData.get(com.tencent.qqnt.qbasealbum.ktx.b.c(localMediaInfo));
            if (uIStateData4 != null && (data = uIStateData4.getData()) != null && data.remove(localMediaInfo)) {
                z18 = true;
            }
            if (z18) {
                String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(localMediaInfo);
                Intrinsics.checkNotNull(c16);
                linkedHashSet.add(c16);
            }
            if (localMediaInfo.getSelectStatus() == 1) {
                selectedMediaViewModel.Z1(com.tencent.qqnt.qbasealbum.ktx.b.e(localMediaInfo), localMediaInfo);
            }
        }
        if (linkedHashSet.contains(this.currentAlbumId) && (uIStateData = uiStateData.get(this.currentAlbumId)) != null) {
            liveData.postValue(uIStateData);
        }
    }

    private final void r2(o event, Map<String, UIStateData<List<LocalMediaInfo>>> uiStateData, MediatorLiveData<UIStateData<List<LocalMediaInfo>>> liveData) {
        UIStateData<List<LocalMediaInfo>> uIStateData;
        List<LocalMediaInfo> data;
        List<LocalMediaInfo> data2;
        List<LocalMediaInfo> data3;
        List<LocalMediaInfo> data4;
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        UIStateData<List<LocalMediaInfo>> uIStateData2 = uiStateData.get(aVar.a());
        boolean z16 = false;
        if (uIStateData2 != null && (data4 = uIStateData2.getData()) != null && data4.contains(event.b())) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        UIStateData<List<LocalMediaInfo>> uIStateData3 = uiStateData.get(aVar.a());
        if (uIStateData3 != null && (data3 = uIStateData3.getData()) != null && event.c() <= data3.size()) {
            data3.add(event.c(), event.b());
        }
        UIStateData<List<LocalMediaInfo>> uIStateData4 = uiStateData.get(aVar.b());
        if (uIStateData4 != null && (data2 = uIStateData4.getData()) != null && com.tencent.qqnt.qbasealbum.ktx.b.o(event.b()) && event.d() <= data2.size()) {
            data2.add(event.d(), event.b());
        }
        UIStateData<List<LocalMediaInfo>> uIStateData5 = uiStateData.get(com.tencent.qqnt.qbasealbum.ktx.b.c(event.b()));
        if (uIStateData5 != null && (data = uIStateData5.getData()) != null && event.a() <= data.size()) {
            data.add(event.a(), event.b());
        }
        if (o2(event.b()) && (uIStateData = uiStateData.get(this.currentAlbumId)) != null) {
            liveData.postValue(uIStateData);
        }
    }

    private final void s2(p event, SelectedMediaViewModel selectedMediaViewModel, Map<String, UIStateData<List<LocalMediaInfo>>> uiStateData, MediatorLiveData<UIStateData<List<LocalMediaInfo>>> liveData) {
        UIStateData<List<LocalMediaInfo>> uIStateData;
        List<LocalMediaInfo> data;
        UIStateData<List<LocalMediaInfo>> uIStateData2;
        List<LocalMediaInfo> data2;
        List<LocalMediaInfo> data3;
        List<LocalMediaInfo> data4;
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        UIStateData<List<LocalMediaInfo>> uIStateData3 = uiStateData.get(aVar.a());
        boolean z16 = false;
        if (uIStateData3 != null && (data4 = uIStateData3.getData()) != null && !data4.contains(event.a())) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        UIStateData<List<LocalMediaInfo>> uIStateData4 = uiStateData.get(aVar.a());
        if (uIStateData4 != null && (data3 = uIStateData4.getData()) != null) {
            data3.remove(event.a());
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(event.a()) && (uIStateData2 = uiStateData.get(aVar.b())) != null && (data2 = uIStateData2.getData()) != null) {
            data2.remove(event.a());
        }
        UIStateData<List<LocalMediaInfo>> uIStateData5 = uiStateData.get(com.tencent.qqnt.qbasealbum.ktx.b.c(event.a()));
        if (uIStateData5 != null && (data = uIStateData5.getData()) != null) {
            data.remove(event.a());
        }
        if (o2(event.a()) && (uIStateData = uiStateData.get(this.currentAlbumId)) != null) {
            liveData.postValue(uIStateData);
        }
        if (event.a().getSelectStatus() == 1) {
            selectedMediaViewModel.Z1(com.tencent.qqnt.qbasealbum.ktx.b.e(event.a()), event.a());
        }
    }

    private final long t2(com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        Object obj;
        Long l3;
        Map<String, Object> d16 = mediaRepoData.d();
        Map map = null;
        if (d16 != null) {
            obj = d16.get("fetchSeqKey");
        } else {
            obj = null;
        }
        if (TypeIntrinsics.isMutableMap(obj)) {
            map = (Map) obj;
        }
        if (map != null && (l3 = (Long) map.get(mediaRepoData.a())) != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final boolean w2(com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        Object obj;
        Map<String, Object> d16 = mediaRepoData.d();
        Boolean bool = null;
        if (d16 != null) {
            obj = d16.get("firstPageFlag");
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        }
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    private final void y2(m event) {
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 || !com.tencent.qqnt.qbasealbum.ktx.b.o(event.b())) {
                    return;
                }
                p2(event, this.albumIdToVideosUIStateData, this.videosMediatorLiveData);
                return;
            }
            p2(event, this.albumIdToMediaUIStateData, this.mediaMediatorLiveData);
            return;
        }
        if (com.tencent.qqnt.qbasealbum.ktx.b.o(event.b())) {
            return;
        }
        p2(event, this.albumIdToImagesUIStateData, this.imagesMediatorLiveData);
    }

    private final void z2(n event, SelectedMediaViewModel selectedMediaViewModel) {
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    q2(event, this.albumIdToVideosUIStateData, this.videosMediatorLiveData, selectedMediaViewModel);
                    return;
                }
                return;
            }
            q2(event, this.albumIdToMediaUIStateData, this.mediaMediatorLiveData, selectedMediaViewModel);
            return;
        }
        q2(event, this.albumIdToImagesUIStateData, this.imagesMediatorLiveData, selectedMediaViewModel);
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    @NotNull
    protected MediatorLiveData<UIStateData<List<LocalMediaInfo>>> W1(@NotNull PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediatorLiveData) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pageType);
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        int i3 = c.f360834a[pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return this.mediaMediatorLiveData;
                }
                return this.videosMediatorLiveData;
            }
            return this.mediaMediatorLiveData;
        }
        return this.imagesMediatorLiveData;
    }

    public void fetchFirstPageMedia() {
        Map<String, ? extends Object> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        ox3.a.j(PickerLocalMediaViewModel$fetchFirstPageMedia$1.INSTANCE);
        this.lastSeq.put(this.currentAlbumId, Long.valueOf(System.currentTimeMillis()));
        ox3.a.a("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$fetchFirstPageMedia$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Map map;
                String str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                map = PickerLocalMediaViewModel.this.lastSeq;
                str = PickerLocalMediaViewModel.this.currentAlbumId;
                return "fetchFirstPageMedia, fetchSeq:" + map.get(str);
            }
        });
        this.albumIdToLoadingStatus.put(this.currentAlbumId, new b(false, true, 0, 4, null));
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("firstPageFlag", Boolean.TRUE), TuplesKt.to("fetchSeqKey", new HashMap(this.lastSeq)));
        this.localMediaRepository.b(this.currentAlbumId, 60, mapOf);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "QBaseAlbum.MediaLoad";
    }

    @Override // com.tencent.qqnt.qbasealbum.base.repository.b.InterfaceC9681b
    @WorkerThread
    public void j0(@NotNull final com.tencent.qqnt.qbasealbum.base.repository.a mediaRepoData) {
        boolean z16;
        Map<String, ? extends Object> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) mediaRepoData);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
        ox3.a.g("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$onQueryNextFinish$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.base.repository.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onQueryFinish: mediaRepoData[" + com.tencent.qqnt.qbasealbum.base.repository.a.this + "]";
            }
        });
        long t26 = t2(mediaRepoData);
        Long l3 = this.lastSeq.get(mediaRepoData.a());
        if (l3 == null || t26 != l3.longValue()) {
            ox3.a.d("QBaseAlbum.LocalMediaDataHub", PickerLocalMediaViewModel$onQueryNextFinish$2.INSTANCE);
            return;
        }
        final boolean w26 = w2(mediaRepoData);
        if (w26) {
            E2(mediaRepoData);
            ox3.a.j(new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$onQueryNextFinish$3
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.base.repository.a.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "fetch first page media done!, " + com.tencent.qqnt.qbasealbum.base.repository.a.this.c().size();
                }
            });
        }
        ConcurrentHashMap<String, b> concurrentHashMap = this.albumIdToLoadingStatus;
        String a16 = mediaRepoData.a();
        b bVar = concurrentHashMap.get(a16);
        if (bVar == null) {
            ox3.a.f("QBaseAlbum.MediaLoad", new Function0<String>(this) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$onQueryNextFinish$loadingStatus$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PickerLocalMediaViewModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.qqnt.qbasealbum.base.repository.a.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    ConcurrentHashMap concurrentHashMap2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    String a17 = com.tencent.qqnt.qbasealbum.base.repository.a.this.a();
                    concurrentHashMap2 = this.this$0.albumIdToLoadingStatus;
                    return "onQueryFinish, " + a17 + " not in " + concurrentHashMap2;
                }
            });
            bVar = new b(false, true, 0, 4, null);
            b putIfAbsent = concurrentHashMap.putIfAbsent(a16, bVar);
            if (putIfAbsent != null) {
                bVar = putIfAbsent;
            }
        }
        final b bVar2 = bVar;
        if (mediaRepoData.f() && mediaRepoData.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar2.d(z16);
        bVar2.e(mediaRepoData.e());
        if (!Intrinsics.areEqual(mediaRepoData.a(), this.currentAlbumId)) {
            bVar2.e(false);
        }
        ox3.a.g("QBaseAlbum.MediaLoad", new Function0<String>(w26, bVar2) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$onQueryNextFinish$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $isFirstFetch;
            final /* synthetic */ PickerLocalMediaViewModel.b $loadingStatus;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$isFirstFetch = w26;
                this.$loadingStatus = bVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, com.tencent.qqnt.qbasealbum.base.repository.a.this, Boolean.valueOf(w26), bVar2);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "onQueryFinish, isSuccess=" + com.tencent.qqnt.qbasealbum.base.repository.a.this.f() + ", isFirstFetch=" + this.$isFirstFetch + ", needLoadMore=" + this.$loadingStatus.a();
            }
        });
        H2(mediaRepoData);
        J2(mediaRepoData);
        F2(mediaRepoData);
        if (mediaRepoData.b() && mediaRepoData.e() && Intrinsics.areEqual(mediaRepoData.a(), this.currentAlbumId)) {
            bVar2.f(bVar2.b() + 1);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("timesOfQuery", Integer.valueOf(bVar2.b())), TuplesKt.to("fetchSeqKey", new HashMap(this.lastSeq)));
            this.localMediaRepository.b(this.currentAlbumId, 600, mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onCleared();
            LocalMediaDataHub.INSTANCE.a().e0();
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    public void onMediaInit(@NotNull List<LocalMediaInfo> selectedMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) selectedMedia);
        } else {
            Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        }
    }

    public final void setIntent(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.hostFragmentIntent = intent;
        }
    }

    public void switchAlbum(@Nullable final String albumId) {
        boolean z16;
        UIStateData<List<LocalMediaInfo>> uIStateData;
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) albumId);
            return;
        }
        if (Intrinsics.areEqual(this.currentAlbumId, albumId)) {
            return;
        }
        ox3.a.a("QBaseAlbum.MediaLoad", new Function0<String>(albumId) { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$switchAlbum$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $albumId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$albumId = albumId;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) albumId);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                return "switchAlbum: albumId=" + this.$albumId;
            }
        });
        T1().postValue(albumId);
        UIStateData<List<LocalMediaInfo>> obtainEmpty = UIStateData.obtainEmpty();
        this.mediaMediatorLiveData.postValue(obtainEmpty);
        this.videosMediatorLiveData.postValue(obtainEmpty);
        this.imagesMediatorLiveData.postValue(obtainEmpty);
        if (albumId != null && albumId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        this.currentAlbumId = albumId;
        int i3 = c.f360834a[this.pageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 3) {
                uIStateData = this.albumIdToMediaUIStateData.get(this.currentAlbumId);
            } else {
                uIStateData = this.albumIdToVideosUIStateData.get(this.currentAlbumId);
            }
        } else {
            uIStateData = this.albumIdToImagesUIStateData.get(this.currentAlbumId);
        }
        if (uIStateData == null) {
            this.lastSeq.put(this.currentAlbumId, Long.valueOf(System.currentTimeMillis()));
            this.albumIdToLoadingStatus.put(this.currentAlbumId, new b(false, true, 0, 4, null));
            ox3.a.a("QBaseAlbum.MediaLoad", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$switchAlbum$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    Map map;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    map = PickerLocalMediaViewModel.this.lastSeq;
                    str = PickerLocalMediaViewModel.this.currentAlbumId;
                    return "switchAlbum, mediaUIStateData == null, queryMediaNext, fetchSeq:" + map.get(str);
                }
            });
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("firstPageFlag", Boolean.TRUE), TuplesKt.to("fetchSeqKey", new HashMap(this.lastSeq)));
            this.localMediaRepository.b(this.currentAlbumId, 60, mapOf2);
            return;
        }
        this.mediaMediatorLiveData.postValue(uIStateData);
        UIStateData<List<LocalMediaInfo>> uIStateData2 = this.albumIdToVideosUIStateData.get(this.currentAlbumId);
        if (uIStateData2 == null) {
            uIStateData2 = UIStateData.obtainEmpty();
        }
        this.videosMediatorLiveData.postValue(uIStateData2);
        UIStateData<List<LocalMediaInfo>> uIStateData3 = this.albumIdToImagesUIStateData.get(this.currentAlbumId);
        if (uIStateData3 == null) {
            uIStateData3 = UIStateData.obtainEmpty();
        }
        this.imagesMediatorLiveData.postValue(uIStateData3);
        b bVar = this.albumIdToLoadingStatus.get(this.currentAlbumId);
        if (bVar != null && bVar.a() && !bVar.c()) {
            ox3.a.a("QBaseAlbum.MediaLoad", PickerLocalMediaViewModel$switchAlbum$3$1.INSTANCE);
            bVar.e(true);
            bVar.f(bVar.b() + 1);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("timesOfQuery", Integer.valueOf(bVar.b())), TuplesKt.to("fetchSeqKey", new HashMap(this.lastSeq)));
            this.localMediaRepository.b(this.currentAlbumId, 600, mapOf);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    @NotNull
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    public MediatorLiveData<UIStateData<List<LocalMediaInfo>>> U1(@NotNull PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MediatorLiveData) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pageType);
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        return W1(pageType);
    }

    public final void v2(@NotNull com.tencent.qqnt.qbasealbum.datahub.a event, @NotNull SelectedMediaViewModel selectedMediaViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event, (Object) selectedMediaViewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        if (event instanceof p) {
            B2((p) event, selectedMediaViewModel);
            return;
        }
        if (event instanceof o) {
            A2((o) event);
            return;
        }
        if (event instanceof m) {
            y2((m) event);
            return;
        }
        if (event instanceof n) {
            z2((n) event, selectedMediaViewModel);
        } else if (event instanceof q) {
            C2((q) event);
        } else if (event instanceof r) {
            D2();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x2(@NotNull LiveData<com.tencent.qqnt.qbasealbum.model.b> curSelectedAlbumId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) curSelectedAlbumId);
            return;
        }
        Intrinsics.checkNotNullParameter(curSelectedAlbumId, "curSelectedAlbumId");
        if (this.isAlbumChangeObserved) {
            return;
        }
        this.isAlbumChangeObserved = true;
        W1(this.pageType).removeSource(curSelectedAlbumId);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> W1 = W1(this.pageType);
        final Function1<com.tencent.qqnt.qbasealbum.model.b, Unit> function1 = new Function1<com.tencent.qqnt.qbasealbum.model.b, Unit>() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.PickerLocalMediaViewModel$observeAlbumChange$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PickerLocalMediaViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.qbasealbum.model.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.qqnt.qbasealbum.model.b bVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    PickerLocalMediaViewModel.this.switchAlbum(bVar.b());
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bVar);
                }
            }
        };
        W1.addSource(curSelectedAlbumId, new Observer() { // from class: com.tencent.qqnt.qbasealbum.album.viewmodel.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PickerLocalMediaViewModel.observeAlbumChange$lambda$0(Function1.this, obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/viewmodel/PickerLocalMediaViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "d", "(Z)V", "needLoadMore", "b", "c", "e", "isQuerying", "I", "()I", "f", "(I)V", "timesOfQuery", "<init>", "(ZZI)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean needLoadMore;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isQuerying;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int timesOfQuery;

        public b(boolean z16, boolean z17, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                return;
            }
            this.needLoadMore = z16;
            this.isQuerying = z17;
            this.timesOfQuery = i3;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.needLoadMore;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.timesOfQuery;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isQuerying;
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.needLoadMore = z16;
            }
        }

        public final void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.isQuerying = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.needLoadMore == bVar.needLoadMore && this.isQuerying == bVar.isQuerying && this.timesOfQuery == bVar.timesOfQuery) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.timesOfQuery = i3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            boolean z16 = this.needLoadMore;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isQuerying;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.timesOfQuery;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "LoadingStatus(needLoadMore=" + this.needLoadMore + ", isQuerying=" + this.isQuerying + ", timesOfQuery=" + this.timesOfQuery + ")";
        }

        public /* synthetic */ b(boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, z17, (i16 & 4) != 0 ? 1 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }
}
