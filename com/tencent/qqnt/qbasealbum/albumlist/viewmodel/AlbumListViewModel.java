package com.tencent.qqnt.qbasealbum.albumlist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.albumlist.adapter.c;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.model.b;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ox3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\"\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002J\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\fJ\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000eJ\u0006\u0010\u0010\u001a\u00020\u0007J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R2\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "albumInfoList", "Lcom/tencent/qqnt/qbasealbum/model/c;", "info", "", "X1", "", "", "R1", "Landroidx/lifecycle/MediatorLiveData;", "T1", "Landroidx/lifecycle/MutableLiveData;", "U1", "Q1", "Landroidx/lifecycle/LiveData;", "W1", "albumInfo", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "tabType", "Lkotlinx/coroutines/Job;", "Z1", "", "albumId", "S1", "getLogTag", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c;", "i", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c;", "albumRepository", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MediatorLiveData;", "mAlbumListLiveData", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mCurSelectedAlbumId", "D", "mAlbumListVisibleLiveData", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/qbasealbum/albumlist/adapter/c$c;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "albumToClickOperationMap", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AlbumListViewModel extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static int G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<b> mCurSelectedAlbumId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> mAlbumListVisibleLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private HashMap<String, c.InterfaceC9679c> albumToClickOperationMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.qbasealbum.albumlist.repository.c albumRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediatorLiveData<List<b>> mAlbumListLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel$a;", "", "", "ALBUM_QUERY_LIMIT", "I", "a", "()I", "setALBUM_QUERY_LIMIT", "(I)V", "", "QZONE_ALBUM_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AlbumListViewModel.G;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            G = Integer.MAX_VALUE;
        }
    }

    public AlbumListViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.albumRepository = new com.tencent.qqnt.qbasealbum.albumlist.repository.c();
        this.mAlbumListLiveData = new MediatorLiveData<>();
        this.mCurSelectedAlbumId = new MutableLiveData<>();
        this.mAlbumListVisibleLiveData = new MutableLiveData<>();
        this.albumToClickOperationMap = new HashMap<>();
    }

    public static final /* synthetic */ com.tencent.qqnt.qbasealbum.model.c O1(AlbumListViewModel albumListViewModel) {
        albumListViewModel.getClass();
        return null;
    }

    private final boolean R1(List<b> albumInfoList) {
        boolean equals$default;
        if (albumInfoList == null) {
            return false;
        }
        Iterator<b> it = albumInfoList.iterator();
        while (it.hasNext()) {
            equals$default = StringsKt__StringsJVMKt.equals$default(it.next().b(), "qzone_album", false, 2, null);
            if (equals$default) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(List<b> albumInfoList, com.tencent.qqnt.qbasealbum.model.c info) {
        if (R1(albumInfoList)) {
            a.a("AlbumListViewModel", AlbumListViewModel$insertQZoneAlbum$1.INSTANCE);
        }
    }

    public final void Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mAlbumListVisibleLiveData.getValue() != null) {
            MutableLiveData<Boolean> mutableLiveData = this.mAlbumListVisibleLiveData;
            Intrinsics.checkNotNull(mutableLiveData.getValue());
            mutableLiveData.setValue(Boolean.valueOf(!r1.booleanValue()));
            return;
        }
        this.mAlbumListVisibleLiveData.setValue(Boolean.TRUE);
    }

    public final boolean S1(@Nullable String albumId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) albumId)).booleanValue();
        }
        if (this.albumToClickOperationMap.containsKey(albumId)) {
            c.InterfaceC9679c interfaceC9679c = this.albumToClickOperationMap.get(albumId);
            Intrinsics.checkNotNull(interfaceC9679c);
            interfaceC9679c.a();
            return true;
        }
        return false;
    }

    @NotNull
    public final MediatorLiveData<List<b>> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MediatorLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mAlbumListLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mAlbumListVisibleLiveData;
    }

    @NotNull
    public final LiveData<b> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mCurSelectedAlbumId;
    }

    @NotNull
    public final Job Z1(@NotNull TabType tabType) {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Job) iPatchRedirector.redirect((short) 7, (Object) this, (Object) tabType);
        }
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.a()), null, null, new AlbumListViewModel$queryAlbumList$1(this, tabType, null), 3, null);
        return launch$default;
    }

    public final void a2(@NotNull b albumInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) albumInfo);
        } else {
            Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
            this.mCurSelectedAlbumId.setValue(albumInfo);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "AlbumListViewModel";
    }
}
