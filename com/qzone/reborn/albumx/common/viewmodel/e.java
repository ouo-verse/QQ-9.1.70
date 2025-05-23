package com.qzone.reborn.albumx.common.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.PhotoSpec;
import com.tencent.qqnt.kernel.nativeinterface.StPicUrl;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import fj.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\b\b\b&\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0007\u00a2\u0006\u0004\b^\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H&J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00070!j\b\u0012\u0004\u0012\u00020\u0007`\"J.\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00070!j\b\u0012\u0004\u0012\u00020\u0007`\"J\b\u0010(\u001a\u00020\u0005H\u0014J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016R%\u00102\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u000b0\u000b0,8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050,8\u0006\u00a2\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R%\u00109\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u000106060,8\u0006\u00a2\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b8\u00101R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:0,8\u0006\u00a2\u0006\f\n\u0004\b;\u0010/\u001a\u0004\b<\u00101R#\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020?0>8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR(\u0010M\u001a\b\u0012\u0004\u0012\u00020F0E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010U\u001a\u00020N8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010X\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR \u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020:0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010AR\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00030Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006b"}, d2 = {"Lcom/qzone/reborn/albumx/common/viewmodel/e;", "Lcom/qzone/reborn/base/n;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "", "method", "", "f2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "Z1", "getLogTag", "", "e2", "timeId", "R1", "S1", "O1", "i2", "P1", "j2", "M1", SemanticAttributes.DbSystemValues.H2, "Q1", "Lo9/f;", "requestBean", "T1", "id", "listener", "g2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueTaskInfo;", "taskInfo", "N1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "W1", "spaceId", NotifyMsgApiImpl.KEY_GROUP_TYPE, "mediaList", "m2", "onCleared", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "state", "onStateChange", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "d2", "()Landroidx/lifecycle/MutableLiveData;", "isBatchOperateMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c2", "selectedModeChange", "", BdhLogUtil.LogTag.Tag_Conn, ICustomDataEditor.STRING_ARRAY_PARAM_2, "selectMediaCount", "Lcom/qzone/reborn/albumx/common/viewmodel/a;", "D", "X1", "currentFinishDownloadTask", "", "Lvh/a;", "E", "Ljava/util/Map;", "b2", "()Ljava/util/Map;", "selectMediaMap", "", "Lcom/qzone/reborn/albumx/common/bean/a;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "U1", "()Ljava/util/List;", "l2", "(Ljava/util/List;)V", "allBatch", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "G", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfoData", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "k2", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfoData", "H", "I", "increaseBatchId", "downloadTaskMap", "", "J", "Ljava/util/Set;", "registerSpaceIdSet", "<init>", "()V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class e extends com.qzone.reborn.base.n implements RFWDownloadQueueResultListener {

    /* renamed from: H, reason: from kotlin metadata */
    private int increaseBatchId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> isBatchOperateMode = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Unit> selectedModeChange = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Integer> selectMediaCount = new MutableLiveData<>(0);

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<a> currentFinishDownloadTask = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private final Map<String, vh.a> selectMediaMap = new LinkedHashMap();

    /* renamed from: F, reason: from kotlin metadata */
    private List<com.qzone.reborn.albumx.common.bean.a> allBatch = new ArrayList();

    /* renamed from: G, reason: from kotlin metadata */
    private CommonAlbumInfo albumInfoData = new CommonAlbumInfo();

    /* renamed from: I, reason: from kotlin metadata */
    private final Map<String, a> downloadTaskMap = new LinkedHashMap();

    /* renamed from: J, reason: from kotlin metadata */
    private final Set<String> registerSpaceIdSet = new LinkedHashSet();

    private final String Z1(CommonStMedia media) {
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            return media.getImage().getLloc();
        }
        return media.getVideo().getCover().getLloc();
    }

    private final void f2(String method) {
        String logTag = getLogTag();
        Object[] array = this.selectMediaMap.keySet().toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d(logTag, 1, "[" + method + "]  | selectMediaIdList = " + arrays);
    }

    public final void M1() {
        Iterator<T> it = this.allBatch.iterator();
        while (it.hasNext()) {
            P1(((com.qzone.reborn.albumx.common.bean.a) it.next()).getTimeId());
        }
        f2("addAllSelectMedia");
    }

    public abstract void N1(RFWDownloadQueueTaskInfo taskInfo);

    public final void O1(String timeId, CommonStMedia media) {
        String b16;
        Intrinsics.checkNotNullParameter(timeId, "timeId");
        if (media != null && (b16 = aa.e.f25753a.b(media)) != null) {
            this.selectMediaMap.put(b16, new vh.a(timeId, media));
        }
        this.selectMediaCount.postValue(Integer.valueOf(this.selectMediaMap.size()));
        this.selectedModeChange.postValue(Unit.INSTANCE);
    }

    public final void Q1() {
        this.selectMediaMap.clear();
        this.selectMediaCount.postValue(Integer.valueOf(this.selectMediaMap.size()));
        this.isBatchOperateMode.postValue(Boolean.FALSE);
        this.selectedModeChange.postValue(Unit.INSTANCE);
        f2("cancelSelectMedia");
    }

    public final boolean R1(String timeId) {
        Intrinsics.checkNotNullParameter(timeId, "timeId");
        int i3 = 0;
        for (com.qzone.reborn.albumx.common.bean.a aVar : this.allBatch) {
            if (Intrinsics.areEqual(aVar.getTimeId(), timeId)) {
                i3 += aVar.getBatchInfo().j().size();
            }
        }
        Iterator<T> it = this.selectMediaMap.values().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((vh.a) it.next()).getTimeId(), timeId)) {
                i16++;
            }
        }
        return i16 == i3;
    }

    public final boolean S1(CommonStMedia media) {
        Intrinsics.checkNotNullParameter(media, "media");
        return this.selectMediaMap.containsKey(aa.e.f25753a.b(media));
    }

    public abstract void T1(o9.f requestBean);

    public final List<com.qzone.reborn.albumx.common.bean.a> U1() {
        return this.allBatch;
    }

    public final ArrayList<CommonStMedia> W1() {
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        Iterator<T> it = this.selectMediaMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((vh.a) it.next()).getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams.ParamKey.MEDIA java.lang.String());
        }
        return arrayList;
    }

    public final MutableLiveData<a> X1() {
        return this.currentFinishDownloadTask;
    }

    public final MutableLiveData<Integer> a2() {
        return this.selectMediaCount;
    }

    public final Map<String, vh.a> b2() {
        return this.selectMediaMap;
    }

    public final MutableLiveData<Unit> c2() {
        return this.selectedModeChange;
    }

    public final MutableLiveData<Boolean> d2() {
        return this.isBatchOperateMode;
    }

    public final boolean e2() {
        Integer value;
        Iterator<T> it = this.allBatch.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((com.qzone.reborn.albumx.common.bean.a) it.next()).getBatchInfo().j().size();
        }
        Integer value2 = this.selectMediaCount.getValue();
        Intrinsics.checkNotNull(value2);
        return value2.intValue() > 0 && (value = this.selectMediaCount.getValue()) != null && value.intValue() == i3;
    }

    public abstract void g2(String id5, RFWDownloadQueueResultListener listener);

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "CommonAlbumOperateViewModel";
    }

    public final void h2() {
        this.selectMediaMap.clear();
        this.selectMediaCount.postValue(Integer.valueOf(this.selectMediaMap.size()));
        this.selectedModeChange.postValue(Unit.INSTANCE);
        f2("removeAllSelectMedia");
    }

    public final void k2(CommonAlbumInfo commonAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<set-?>");
        this.albumInfoData = commonAlbumInfo;
    }

    public final void l2(List<com.qzone.reborn.albumx.common.bean.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allBatch = list;
    }

    public final void m2(String spaceId, String groupType, ArrayList<CommonStMedia> mediaList) {
        String str;
        String a16;
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (!this.registerSpaceIdSet.contains(spaceId)) {
            g2(spaceId, this);
            this.registerSpaceIdSet.add(spaceId);
        }
        a aVar = new a(this.increaseBatchId, mediaList.size(), System.currentTimeMillis(), 0, 0, 24, null);
        this.downloadTaskMap.put(String.valueOf(this.increaseBatchId), aVar);
        QLog.d(getLogTag(), 1, "startDownloadMediaList! info: " + aVar);
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia media = it.next();
            HashMap<String, String> hashMap = new HashMap<>();
            if (media.getType() == 1) {
                str = media.getVideo().getUrl();
                hashMap.put("ext_key_is_video", "1");
                ArrayList arrayList = new ArrayList();
                Iterator<T> it5 = media.getVideo().getCover().e().iterator();
                while (it5.hasNext()) {
                    arrayList.add(xh.h.j((CommonStPicSpecUrlEntry) it5.next()));
                }
                StPicUrl g16 = t.f399471a.g(arrayList);
                if (g16 != null) {
                    String str2 = g16.url;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.url");
                    hashMap.put("ext_key_video_url", str2);
                }
                a16 = com.qzone.util.l.a(R.string.f169544uy4);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026ad_list_media_video_type)");
                hashMap.put("ext_key_video_id", media.getVideo().getId());
            } else {
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it6 = media.getImage().e().iterator();
                while (it6.hasNext()) {
                    arrayList2.add(xh.h.j((CommonStPicSpecUrlEntry) it6.next()));
                }
                StPicUrl j3 = t.f399471a.j(arrayList2, PhotoSpec.KPHOTOSPECDOWNLOAD);
                if (j3 != null) {
                    str = j3.url;
                    Intrinsics.checkNotNullExpressionValue(str, "it.url");
                } else {
                    str = "";
                }
                hashMap.put("ext_key_is_video", "0");
                a16 = com.qzone.util.l.a(R.string.uwv);
                Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026load_list_media_pic_type)");
                Intrinsics.checkNotNullExpressionValue(media, "media");
                hashMap.put("ext_key_pic_id", Z1(media));
            }
            RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo = new RFWDownloadQueueTaskInfo(str);
            String uinString = LoginData.getInstance().getUinString();
            Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
            hashMap.put("ext_key_uin", uinString);
            hashMap.put("ext_key_uid", this.albumInfoData.getCreator().getUid());
            hashMap.put("ext_key_task_desc", com.qzone.util.l.a(R.string.toe) + this.albumInfoData.getName() + com.qzone.util.l.a(R.string.uwn) + a16);
            hashMap.put("ext_key_space_id", spaceId);
            hashMap.put("ext_key_space_type", groupType);
            hashMap.put("CommonAlbumOperateViewModel_ext_key_download_batch_id", String.valueOf(this.increaseBatchId));
            rFWDownloadQueueTaskInfo.setExtMap(hashMap);
            N1(rFWDownloadQueueTaskInfo);
        }
        this.increaseBatchId++;
        Q1();
    }

    public abstract void n2(String id5, RFWDownloadQueueResultListener listener);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Iterator<String> it = this.registerSpaceIdSet.iterator();
        while (it.hasNext()) {
            n2(it.next(), this);
        }
    }

    public final void P1(String timeId) {
        if (timeId != null) {
            for (com.qzone.reborn.albumx.common.bean.a aVar : this.allBatch) {
                if (Intrinsics.areEqual(aVar.getTimeId(), timeId)) {
                    Iterator<T> it = aVar.getBatchInfo().j().iterator();
                    while (it.hasNext()) {
                        O1(timeId, (CommonStMedia) it.next());
                    }
                }
            }
        }
        f2("addSelectTimeBatch");
    }

    public final void i2(CommonStMedia media) {
        if (media != null) {
            Map<String, vh.a> map = this.selectMediaMap;
        }
        this.selectMediaCount.postValue(Integer.valueOf(this.selectMediaMap.size()));
        this.selectedModeChange.postValue(Unit.INSTANCE);
        f2("removeSelectMedia");
    }

    public final void j2(String timeId) {
        if (timeId != null) {
            for (com.qzone.reborn.albumx.common.bean.a aVar : this.allBatch) {
                if (Intrinsics.areEqual(aVar.getTimeId(), timeId)) {
                    Iterator<T> it = aVar.getBatchInfo().j().iterator();
                    while (it.hasNext()) {
                        i2((CommonStMedia) it.next());
                    }
                }
            }
        }
        this.selectedModeChange.postValue(Unit.INSTANCE);
        f2("removeSelectTimeBatch");
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData state) {
        String a16;
        a aVar;
        DownloadState state2 = state != null ? state.getState() : null;
        DownloadState downloadState = DownloadState.STATE_SUCCESS;
        if ((state2 != downloadState && state2 != DownloadState.STATE_ERROR && state2 != DownloadState.STATE_CANCEL) || (a16 = f.a(state)) == null || (aVar = this.downloadTaskMap.get(a16)) == null) {
            return;
        }
        if (state2 == downloadState) {
            aVar.f(aVar.getSuccessCount() + 1);
        } else {
            aVar.e(aVar.getFailCount() + 1);
        }
        if (aVar.d()) {
            QLog.d(getLogTag(), 1, "onDownload finish! info: " + aVar);
            this.downloadTaskMap.remove(a16);
            this.currentFinishDownloadTask.postValue(aVar);
        }
    }
}
