package com.tencent.mobileqq.flock.publish.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.flock.FlockFeedGalleryActivity;
import com.tencent.mobileqq.flock.publish.FlockPublishGalleryLayerFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010<\u001a\u00020\u0007\u00a2\u0006\u0004\b=\u0010>J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J&\u0010\"\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0010J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010&\u001a\u00020%H\u0016R\u0014\u0010)\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010/R\u001a\u00105\u001a\b\u0012\u0004\u0012\u000202018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000202068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishBaseViewModel;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "toAddMedia", "", "P1", "Landroid/content/Intent;", "data", "W1", "U1", "", "S1", "", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "itemLayoutPosition", "Z1", "fromPosInMediaList", "toPosInMediaList", "d2", "posInMedia", "g2", "R1", "Q1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c2", "f2", "Landroid/widget/ImageView;", "clickView", QAdVrReportParams.ParamKey.MEDIA, "position", "b2", QzoneIPCModule.RESULT_CODE, "e2", "", "getLogTag", "E", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "placeholderMedia", UserInfo.SEX_FEMALE, "Ljava/util/List;", "_selectedMedia", "G", "getSelectedMedia", "()Ljava/util/List;", "selectedMedia", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/flock/publish/viewmodel/m;", "H", "Landroidx/lifecycle/MutableLiveData;", "_selectedMediaChangedAction", "Landroidx/lifecycle/LiveData;", "I", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "selectedMediaChangedAction", "intent", "<init>", "(Landroid/content/Intent;)V", "J", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends FlockPublishBaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LocalMediaInfo placeholderMedia;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> _selectedMedia;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<LocalMediaInfo> selectedMedia;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<m> _selectedMediaChangedAction;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<m> selectedMediaChangedAction;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/viewmodel/b$a;", "", "", "FLOCK_GALLERY_MEDIA", "Ljava/lang/String;", "FLOCK_GALLERY_MEDIA_POSITION", "", "LIMIT_IMAGE_COUNT", "I", "REQUEST_CODE_LAYER", "REQUEST_CODE_WINK_HOME", "RESULT_CODE_LAYER_DELETE", "RESULT_CODE_LAYER_EDITED", "TAG", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.viewmodel.b$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if (r7 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(@NotNull Intent intent) {
        super(intent);
        List<? extends LocalMediaInfo> arrayList;
        y45.i[] iVarArr;
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.placeholderMedia = new LocalMediaInfo();
        ArrayList arrayList2 = new ArrayList();
        this._selectedMedia = arrayList2;
        this.selectedMedia = arrayList2;
        MutableLiveData<m> mutableLiveData = new MutableLiveData<>();
        this._selectedMediaChangedAction = mutableLiveData;
        this.selectedMediaChangedAction = mutableLiveData;
        y45.b M1 = M1();
        if (M1 != null && (iVarArr = M1.f449375j) != null) {
            ArrayList arrayList3 = new ArrayList(iVarArr.length);
            for (y45.i iVar : iVarArr) {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                localMediaInfo.path = iVar.f449405c;
                localMediaInfo.mediaWidth = iVar.f449403a;
                localMediaInfo.mediaHeight = iVar.f449404b;
                arrayList3.add(localMediaInfo);
            }
            arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
        }
        arrayList = new ArrayList<>();
        arrayList.add(this.placeholderMedia);
        P1(arrayList);
    }

    private final void P1(List<? extends LocalMediaInfo> toAddMedia) {
        CollectionsKt__MutableCollectionsKt.addAll(S1(), toAddMedia);
        if (this._selectedMedia.size() > 9) {
            CollectionsKt__MutableCollectionsKt.removeLast(this._selectedMedia);
        }
        this._selectedMediaChangedAction.postValue(new m());
    }

    private final List<LocalMediaInfo> S1() {
        if (!this._selectedMedia.isEmpty() && !X1()) {
            return this._selectedMedia.subList(0, r0.size() - 1);
        }
        return this._selectedMedia;
    }

    private final void U1(Intent data) {
        int i3;
        if (data != null) {
            i3 = data.getIntExtra("flock_gallery_media_position", -1);
        } else {
            i3 = -1;
        }
        if (i3 == -1) {
            QLog.i("FlockPublishGalleryViewModel", 1, "[handleLayerDeleteMedia] deleteMediaPosition invalid");
        } else {
            g2(i3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W1(Intent data) {
        Serializable serializable;
        ArrayList arrayList;
        Object orNull;
        List list;
        Object firstOrNull;
        LocalMediaInfo localMediaInfo = null;
        if (data != null) {
            serializable = data.getSerializableExtra("OUTPUT_MEDIA");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList != null && list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            localMediaInfo = (LocalMediaInfo) firstOrNull;
        }
        if (localMediaInfo == null) {
            QLog.i("FlockPublishGalleryViewModel", 1, "[handleWinkEditorResult] outputMedia is null");
            return;
        }
        int intExtra = data.getIntExtra("flock_gallery_media_position", -1);
        if (intExtra != -1) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(S1(), intExtra);
            LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) orNull;
            if (localMediaInfo2 == null) {
                QLog.i("FlockPublishGalleryViewModel", 1, "[handleWinkEditorResult] editedMedia is null");
                return;
            }
            localMediaInfo2.path = localMediaInfo.path;
            localMediaInfo2.mediaWidth = localMediaInfo.thumbWidth;
            localMediaInfo2.mediaHeight = localMediaInfo.mediaHeight;
            localMediaInfo2.missionID = localMediaInfo.missionID;
            this._selectedMediaChangedAction.postValue(new j(intExtra));
            return;
        }
        QLog.i("FlockPublishGalleryViewModel", 1, "[handleLayerDeleteMedia] deleteMediaPosition invalid");
    }

    private final boolean X1() {
        if (this._selectedMedia.size() == 9 && a2(this._selectedMedia)) {
            return true;
        }
        return false;
    }

    private final boolean a2(List<? extends LocalMediaInfo> list) {
        Object last;
        boolean z16;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
        String str = ((LocalMediaInfo) last).path;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    @NotNull
    public final List<LocalMediaInfo> Q1() {
        List<LocalMediaInfo> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            list = CollectionsKt___CollectionsKt.toList(S1());
            return list;
        }
        return (List) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public final int R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (X1()) {
            return 9;
        }
        return this._selectedMedia.size() - 1;
    }

    @NotNull
    public final LiveData<m> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.selectedMediaChangedAction;
    }

    public final boolean Z1(int itemLayoutPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, itemLayoutPosition)).booleanValue();
        }
        if (itemLayoutPosition + 1 > R1()) {
            return true;
        }
        return false;
    }

    public final void b2(@NotNull Activity activity, @NotNull ImageView clickView, @NotNull LocalMediaInfo media, int position) {
        List listOf;
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, activity, clickView, media, Integer.valueOf(position));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        Intrinsics.checkNotNullParameter(media, "media");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setMediaId("");
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId("");
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        if (com.tencent.mobileqq.flock.ktx.g.a(media.path)) {
            rFWPicInfo.setUrl(media.path);
        } else {
            rFWPicInfo.setLocalPath(media.path);
        }
        rFWPicInfo.setWidth(media.mediaWidth);
        rFWPicInfo.setHeight(media.mediaHeight);
        rFWLayerPicInfo.setBigPicInfo(rFWPicInfo);
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(rFWLayerItemMediaInfo);
        Bundle bundle = new Bundle();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(media);
        bundle.putSerializable("flock_gallery_media", arrayListOf);
        bundle.putInt("flock_gallery_media_position", position);
        Unit unit = Unit.INSTANCE;
        RFWLayerLaunchUtil.jumpToGallery(activity, clickView, listOf, 0, FlockFeedGalleryActivity.class, FlockPublishGalleryLayerFragment.class, bundle, 101);
    }

    public final void c2(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            qc1.a.f428842a.d(activity, 100, 9, R1());
        }
    }

    public final void d2(int fromPosInMediaList, int toPosInMediaList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(fromPosInMediaList), Integer.valueOf(toPosInMediaList));
            return;
        }
        List<LocalMediaInfo> S1 = S1();
        if (toPosInMediaList == S1.size()) {
            toPosInMediaList--;
        }
        if (fromPosInMediaList == toPosInMediaList) {
            return;
        }
        S1.add(toPosInMediaList, S1.remove(fromPosInMediaList));
        this._selectedMediaChangedAction.postValue(new l(fromPosInMediaList, toPosInMediaList));
    }

    public final void e2(int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, resultCode, (Object) data);
        } else {
            if (resultCode != 100) {
                if (resultCode == 101) {
                    U1(data);
                    return;
                }
                return;
            }
            W1(data);
        }
    }

    public final void f2(@Nullable Intent data) {
        Serializable serializable;
        ArrayList arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) data);
            return;
        }
        List<? extends LocalMediaInfo> list = null;
        if (data != null) {
            serializable = data.getSerializableExtra("OUTPUT_MEDIA");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            list = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        List<? extends LocalMediaInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.i("FlockPublishGalleryViewModel", 1, "[onWinkPickerResult] outputMedia is null");
        } else {
            P1(list);
        }
    }

    public final void g2(int posInMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, posInMedia);
            return;
        }
        List<LocalMediaInfo> list = this._selectedMedia;
        list.remove(posInMedia);
        if (!list.isEmpty() && !a2(list)) {
            this._selectedMediaChangedAction.postValue(new k(posInMedia));
        } else {
            list.add(this.placeholderMedia);
            this._selectedMediaChangedAction.postValue(new m());
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "FlockPublishGalleryViewModel";
    }

    @NotNull
    public final List<LocalMediaInfo> getSelectedMedia() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.selectedMedia;
    }
}
