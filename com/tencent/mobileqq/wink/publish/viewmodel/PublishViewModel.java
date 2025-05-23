package com.tencent.mobileqq.wink.publish.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.IWinkExport;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.event.WinkSaveEditDraftEvent;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.wink.output.QCircleWinkOutputRouterForVideoComment;
import com.tencent.mobileqq.wink.publish.part.PublishContentPart;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTroopViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.tag.TagRetriever;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.mobileqq.winkpublish.model.params.BusinessShareParams;
import com.tencent.mobileqq.winkpublish.model.params.ExportParams;
import com.tencent.mobileqq.winkpublish.model.params.FeedExtraInfo;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.LiteBanner;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.MusicParams;
import com.tencent.mobileqq.winkpublish.model.params.PoiParams;
import com.tencent.mobileqq.winkpublish.model.params.PromotionPublishParams;
import com.tencent.mobileqq.winkpublish.model.params.SchoolParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.mobileqq.winkpublish.report.PublishActivityErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import com.tencent.mobileqq.winkpublish.util.WinkCommonUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.NetworkState;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import k93.c;
import kotlin.Pair;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/* loaded from: classes21.dex */
public class PublishViewModel extends BaseViewModel {
    public static final String N0 = UploadConstants.TAG + "PublishViewModel";
    public static final String O0 = "type_has_show_bubble" + WinkCommonUtil.getCurrentAccountLong();
    public static int P0 = 0;
    public static Map<String, Integer> Q0 = new HashMap();
    public static final String R0 = "is_not_open_allow_download_switch" + WinkCommonUtil.getCurrentAccountLong();
    public boolean F0;
    public PublishTroopViewModel.TroopInfo G0;
    public LiveData<List<ha3.b>> H;
    public boolean I0;
    private String K;
    private boolean L;
    public String M;
    private boolean N;
    private HashMap<String, String> Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f325999a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f326000b0;

    /* renamed from: i0, reason: collision with root package name */
    public String f326008i0;

    /* renamed from: j0, reason: collision with root package name */
    public long f326009j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f326010k0;

    /* renamed from: l0, reason: collision with root package name */
    public long f326011l0;

    /* renamed from: m, reason: collision with root package name */
    protected ArrayList<String> f326012m;

    /* renamed from: m0, reason: collision with root package name */
    public String f326013m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f326014n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f326015o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f326016p0;

    /* renamed from: q0, reason: collision with root package name */
    private Intent f326017q0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f326019s0;

    /* renamed from: w0, reason: collision with root package name */
    private String f326023w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f326024x0;

    /* renamed from: y0, reason: collision with root package name */
    private String f326025y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f326026z0;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<String> f326007i = new MutableLiveData<>();
    public MutableLiveData<ArrayList<LocalMediaInfo>> C = new MutableLiveData<>();
    public final ArrayList<LocalMediaInfo> D = new ArrayList<>();
    public MutableLiveData<PublishContentPart.k> E = new MutableLiveData<>();
    public MutableLiveData<Boolean> F = new MutableLiveData<>();
    public MutableLiveData<Boolean> G = new MutableLiveData<>();
    public MutableLiveData<Boolean> I = new MutableLiveData<>();
    public MutableLiveData<TaskInfo> J = new MutableLiveData<>();
    private String P = "";
    public String Q = "";
    public String R = "";
    public String S = "";
    public String T = "";
    public String U = "";
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private MutableLiveData<Integer> Y = new MutableLiveData<>(0);

    /* renamed from: c0, reason: collision with root package name */
    public boolean f326001c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f326002d0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f326003e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f326004f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    public String f326005g0 = "";

    /* renamed from: h0, reason: collision with root package name */
    private String f326006h0 = "";

    /* renamed from: r0, reason: collision with root package name */
    public int f326018r0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f326020t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private String f326021u0 = "1";

    /* renamed from: v0, reason: collision with root package name */
    private long f326022v0 = -1;
    private final ArrayList<ArrayList<WinkPublishMediaRecord>> A0 = new ArrayList<>();
    public Long B0 = 0L;
    public Long C0 = 0L;
    public Long D0 = 0L;
    public String E0 = "";
    public boolean H0 = false;
    public boolean J0 = false;
    public ITaskListener K0 = null;
    public DeclarationParams L0 = null;
    private boolean M0 = false;

    /* loaded from: classes21.dex */
    class a extends ITaskListener.Stub {
        a() {
        }

        @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
        public void onTaskChange(TaskInfo taskInfo) {
            w53.b.f(PublishViewModel.N0, "onTaskChange, state:" + taskInfo.getState() + ", compose:" + taskInfo.getExportProgress() + ", upload:" + taskInfo.getUploadProgress());
            PublishViewModel.this.J.postValue(taskInfo);
        }
    }

    public static boolean I3() {
        if (uq3.c.X0("qqcircle", "qqcircle_show_associate_tag_panel", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    private boolean M2(BasePartFragment basePartFragment) {
        MetaMaterial metaMaterial;
        String str;
        if (basePartFragment.getActivity() == null || basePartFragment.getActivity().getIntent() == null || (metaMaterial = (MetaMaterial) basePartFragment.getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL)) == null || (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) == null) {
            return false;
        }
        return str.equals(QQWinkConstants.BUSINESS_ZSHOW_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean N2(LocalMediaInfo localMediaInfo) {
        boolean z16;
        if (localMediaInfo.aiTextLabel != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Observable O2(LocalMediaInfo localMediaInfo) {
        return Observable.from(localMediaInfo.aiTextLabel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r2.equals(r3.mOriginPath.get(0)) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ Boolean Q2(String str, LocalMediaInfo localMediaInfo) {
        boolean z16;
        if (!str.equals(localMediaInfo.path)) {
            ArrayList<String> arrayList = localMediaInfo.mOriginPath;
            z16 = false;
            if (arrayList != null) {
                if (arrayList.size() > 0) {
                }
            }
            return Boolean.valueOf(z16);
        }
        z16 = true;
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(String str, float f16, boolean z16, LocalMediaInfo localMediaInfo) {
        localMediaInfo.thumbnailPath = str;
        localMediaInfo.thumbnailProgress = f16;
        localMediaInfo.isProgressThumbnail = z16;
        this.f326003e0 = true;
        this.f326002d0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2() {
        PublishActivityErrorCode publishActivityErrorCode = new PublishActivityErrorCode(PublishActivityErrorCode.ERROR_CODE_NO_SERVICE_ERROR, null);
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setTraceId(this.f326005g0).setKeyEventId("QFS_E_PUBLISH_COMPLETE_TASK").setKeyRetCode(Long.valueOf(publishActivityErrorCode.transformedCode())).setDesc(publishActivityErrorCode.getMessage()).setExt1(String.valueOf(WinkPublishServiceProxy2.getInitError())).setExt2("1").setExt3(String.valueOf(com.tencent.mobileqq.wink.editor.hdr.a.i())));
    }

    private void T1() {
        WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(i2());
        if (this.f326022v0 > 0 && d16 != null && com.tencent.mobileqq.wink.editor.draft.c.v(d16)) {
            this.M0 = true;
            w53.b.f(N0, "cancelPreUploadWhenPreview do cancelPreUpload");
            S1();
        }
    }

    private void T2(Intent intent) {
        String str;
        HashMap<String, String> hashMap;
        String stringExtra = intent.getStringExtra(WinkHostConstants.QZoneConstant.shareSummary());
        this.M = stringExtra;
        if (TextUtils.isEmpty(stringExtra) && (hashMap = this.Z) != null && hashMap.containsKey("content")) {
            this.M = this.Z.get("content");
        }
        String e26 = e2(this.M, this.Z);
        this.M = e26;
        if (e26 == null) {
            this.M = "";
        }
        WinkContext.Companion companion = WinkContext.INSTANCE;
        if (!TextUtils.isEmpty(companion.d().p(QCircleScheme.AttrQQPublish.PUBLISH_CONTENT_PREFIX))) {
            this.P = companion.d().p(QCircleScheme.AttrQQPublish.PUBLISH_CONTENT_PREFIX).trim();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.M);
        TagRetriever tagRetriever = TagRetriever.f326413a;
        sb5.append(tagRetriever.f(intent));
        this.M = sb5.toString();
        if (L2()) {
            str = p2() + this.M;
        } else {
            str = this.M;
        }
        String stringExtra2 = this.f326017q0.getStringExtra(QQWinkTempConstants.MAGIC_STUDIO_PROMPT);
        if (!TextUtils.isEmpty(stringExtra2)) {
            str = stringExtra2 + " " + tagRetriever.f(intent);
        }
        this.E.postValue(new PublishContentPart.k(str, str.length()));
    }

    private void U2(Intent intent) {
        boolean z16 = false;
        this.W = intent.getBooleanExtra(QQWinkConstants.COULD_SHOW_HD, false);
        int hDMode = ((IWinkExport) QRoute.api(IWinkExport.class)).getHDMode(i2());
        if (hDMode > 0) {
            if (hDMode == 2) {
                z16 = true;
            }
            this.V = z16;
            return;
        }
        this.V = this.W;
    }

    private void V2(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(QQWinkConstants.PUBLISH_EDIT_WINK_PUBLISH_DATA);
        this.A0.clear();
        if (arrayList != null) {
            this.A0.addAll(arrayList);
        }
        String stringExtra = intent.getStringExtra(QQWinkConstants.SCHEMA_MATERIAL_ID);
        String stringExtra2 = intent.getStringExtra(QQWinkConstants.SCHEMA_MATERIAL_TYPE);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            ArrayList<WinkPublishMediaRecord> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(stringExtra);
            arrayList2.add(new WinkPublishMediaRecord(stringExtra2, arrayList3));
            this.A0.add(arrayList2);
        }
    }

    private void W2(Intent intent) {
        if (intent == null) {
            w53.b.g(N0, "[loadMediaInfos] invalid intent");
            return;
        }
        this.f326012m = intent.getStringArrayListExtra(WinkHostConstants.PhotoConst.photoPaths());
        HashMap hashMap = (HashMap) intent.getSerializableExtra(WinkHostConstants.QAlbumConstants.selectedMediaInfoHashMap());
        String str = N0;
        w53.b.a(str, "[loadMediaInfos] inputMediaPaths: " + this.f326012m + ", mediaInfoMap: " + hashMap);
        if (this.f326012m != null && hashMap != null) {
            this.D.clear();
            ListIterator<String> listIterator = this.f326012m.listIterator();
            while (listIterator.hasNext()) {
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) hashMap.get(listIterator.next());
                if (localMediaInfo == null) {
                    w53.b.g(N0, "[loadMediaInfos] invalid mediaInfo");
                    listIterator.remove();
                } else {
                    localMediaInfo.thumbnailProgress = -1.0f;
                    this.D.add(localMediaInfo);
                }
            }
            this.C.postValue(this.D);
            return;
        }
        w53.b.g(str, "[loadMediaInfos] invalid media infos");
    }

    private void X1(HashMap<String, String> hashMap) {
        hashMap.put("challenge_manualDeletedTagTitle", com.tencent.mobileqq.wink.model.b.f324006a.c());
        WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(i2());
        if (d16 != null && !d16.getEditDatas().isEmpty()) {
            Iterator<WinkEditData> it = d16.getEditDatas().iterator();
            while (it.hasNext()) {
                WinkEditData next = it.next();
                if (next.getChallengeData() != null && com.tencent.mobileqq.wink.model.b.f324006a.f()) {
                    hashMap.put("challenge_tagTitle", next.getChallengeData().getTagName());
                    hashMap.put("challenge_rotation", String.valueOf(next.getChallengeData().getRotation()));
                    hashMap.put("challenge_scale", String.valueOf(next.getChallengeData().getScale()));
                    hashMap.put("challenge_positionX", String.valueOf(next.getChallengeData().getXAxisPercentage()));
                    hashMap.put("challenge_positionY", String.valueOf(next.getChallengeData().getYAxisPercentage()));
                    w53.b.a(N0, "fillChallengeExtInfo... tag:" + next.getChallengeData().getTagName() + " rotation:" + next.getChallengeData().getRotation() + " scale:" + next.getChallengeData().getScale() + " positionX:" + next.getChallengeData().getXAxisPercentage() + " positionY:" + next.getChallengeData().getYAxisPercentage());
                }
            }
        }
    }

    private void Y2(Intent intent) {
        this.f326008i0 = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_MID);
        this.f326009j0 = intent.getLongExtra(QQWinkConstants.PUBLISH_MUSIC_ID, 0L);
        this.f326010k0 = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_NAME);
        this.f326011l0 = intent.getLongExtra(QQWinkConstants.PUBLISH_MUSIC_START_TIME, 0L);
        this.f326015o0 = intent.getStringExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_AUTHOR_UID);
        this.f326013m0 = intent.getStringExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_ID);
        this.f326016p0 = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_LOCAL_PATH);
        this.f326014n0 = intent.getIntExtra(QQWinkConstants.PUBLISH_SCHEMA_MUSIC_SCENE, 0);
        if (!TextUtils.isEmpty(this.f326008i0) && !this.f326008i0.equals(this.f326013m0)) {
            this.f326014n0 = 0;
        }
    }

    private void Z1(Intent intent) {
        int i3;
        if (intent.hasExtra(QQWinkConstants.PUBLISH_SCHEMA_ENTER_FEED_ID)) {
            WinkDatongCurrentParams.put("xsj_feed_id", intent.getStringExtra(QQWinkConstants.PUBLISH_SCHEMA_ENTER_FEED_ID));
        }
        String stringExtra = intent.getStringExtra(QQWinkConstants.SCHEMA_OPERATION_ACTIVITY_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            WinkDatongCurrentParams.params.put("xsj_operation_activity_id", stringExtra);
        }
        if (this.f325999a0 == 20) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_FROM_LBS_CHECK_BUTTON, Integer.valueOf(i3));
        o3(this.A0);
    }

    @Nullable
    private String a2(HashMap<String, String> hashMap) {
        WinkPublishMediaRecord winkPublishMediaRecord;
        try {
        } catch (Exception e16) {
            w53.b.d(N0, "fillTemplateExtInfo, error ", e16);
        }
        if (this.A0.isEmpty()) {
            return null;
        }
        ArrayList<WinkPublishMediaRecord> arrayList = this.A0.get(0);
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator<WinkPublishMediaRecord> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                winkPublishMediaRecord = it.next();
                if ("template".equals(winkPublishMediaRecord.mediaType) || "libTemplate".equals(winkPublishMediaRecord.mediaType)) {
                    break;
                }
            } else {
                winkPublishMediaRecord = null;
                break;
            }
        }
        if (winkPublishMediaRecord == null) {
            return null;
        }
        String mediaIdStr = winkPublishMediaRecord.getMediaIdStr();
        if (!TextUtils.isEmpty(mediaIdStr)) {
            hashMap.put("tmpl_id", mediaIdStr);
            return mediaIdStr;
        }
        return null;
    }

    private String e2(String str, HashMap<String, String> hashMap) {
        String str2;
        if (hashMap != null && hashMap.containsKey("atuin")) {
            String[] split = hashMap.get("atuin").split(",");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < split.length; i3++) {
                String b16 = com.tencent.mobileqq.wink.publish.util.c.b(split[i3]);
                if (!TextUtils.isEmpty(b16)) {
                    arrayList.add(b16);
                    str2 = b16.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E");
                } else {
                    str2 = split[i3];
                    arrayList.add(str2);
                }
                sb5.append("@{uin:");
                sb5.append(split[i3]);
                sb5.append(",nick:");
                sb5.append(str2);
                sb5.append("} ");
            }
            if (TextUtils.isEmpty(str)) {
                return "\n" + ((Object) sb5);
            }
            return str + "\n" + ((Object) sb5);
        }
        return str;
    }

    private String f2() {
        List<ha3.b> value;
        if (!TextUtils.isEmpty(this.f326024x0)) {
            return this.f326024x0;
        }
        LiveData<List<ha3.b>> liveData = this.H;
        ha3.b bVar = null;
        if (liveData == null) {
            value = null;
        } else {
            value = liveData.getValue();
        }
        if (value != null && value.size() > 0) {
            bVar = value.get(0);
        }
        String p16 = WinkContext.INSTANCE.d().p("taskid");
        this.f326024x0 = p16;
        if (TextUtils.isEmpty(p16) && bVar != null) {
            this.f326024x0 = bVar.f404635t.get("taskid");
        }
        return this.f326024x0;
    }

    private BusinessShareParams f3() {
        if ((this.C0.longValue() != 0 || this.B0.longValue() != 0) && this.F0) {
            return new BusinessShareParams(this.B0.longValue(), this.C0.longValue(), this.D0.longValue(), 3);
        }
        if (this.G0 != null) {
            return new BusinessShareParams(this.G0.getTroopId(), 0L, 0L, 1);
        }
        return null;
    }

    private String g2() {
        List<ha3.b> value;
        if (!TextUtils.isEmpty(this.f326025y0)) {
            return this.f326025y0;
        }
        LiveData<List<ha3.b>> liveData = this.H;
        ha3.b bVar = null;
        if (liveData == null) {
            value = null;
        } else {
            value = liveData.getValue();
        }
        if (value != null && value.size() > 0) {
            bVar = value.get(0);
        }
        String p16 = WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA);
        this.f326025y0 = p16;
        if (TextUtils.isEmpty(p16) && bVar != null) {
            this.f326025y0 = bVar.f404635t.get(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA);
        }
        return this.f326025y0;
    }

    private ExportParams g3() {
        ExportParams exportParams;
        WinkEditDataWrapper d16;
        int i3;
        boolean z16;
        if (K2() && (d16 = com.tencent.mobileqq.wink.editor.draft.a.d(i2())) != null) {
            if (this.V) {
                i3 = 300;
            } else {
                i3 = 200;
            }
            boolean z17 = false;
            if (com.tencent.mobileqq.wink.editor.export.q.c() && WinkExportUtils.N(d16)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (n63.c.f418525a.b()) {
                w53.b.f(N0, "prepareExportParams, debug force close speed test");
            } else {
                z17 = z16;
            }
            exportParams = new ExportParams(i2(), i3, z17);
        } else {
            exportParams = null;
        }
        w53.b.a(N0, "[prepareExportParams] exportParams=" + exportParams);
        return exportParams;
    }

    private HashMap<String, String> h3(HashMap<String, String> hashMap) {
        String str;
        if (x2()) {
            try {
                JSONObject jSONObject = new JSONObject(this.f326017q0.getStringExtra(QQWinkTempConstants.MAIGC_STUDIO_PUBLISH_TRANS));
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.getString(str2));
                }
                if (QzoneConfig.isNotSkipMagicStudioSafeCheck()) {
                    str = "0";
                } else {
                    str = "1";
                }
                hashMap.put(QQWinkTempConstants.MAIGC_STUDIO_AIGC_CHECK_FLAG, str);
            } catch (Exception e16) {
                w53.b.d(N0, "prepareExtInfo: fail", e16);
            }
        }
        return hashMap;
    }

    private FeedParams i3(BasePartFragment basePartFragment, String str) {
        String str2;
        String str3;
        Long l3;
        k93.b value = ((u) basePartFragment.getViewModel(u.class)).L1().getValue();
        String str4 = "";
        if (value == null || (l3 = value.f411915b) == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(l3);
        }
        boolean z16 = ((r) basePartFragment.getViewModel(r.class)).f326066m;
        boolean M1 = ((n) basePartFragment.getViewModel(n.class)).M1();
        ar arVar = ar.f326685a;
        boolean z17 = false;
        if (arVar.e(arVar.k(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA), 0) == 1) {
            z17 = true;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QCircleLpReportDc05494.KEY_UP_TYPE, String.valueOf(this.f326000b0));
        int i3 = this.f325999a0;
        if (i3 > 0) {
            hashMap.put("up_source", String.valueOf(i3));
        }
        hashMap.put(v4.b.CLIENTKEY, str);
        String s26 = s2();
        FeedParams.Builder builder = new FeedParams.Builder();
        if (TextUtils.isEmpty(this.M)) {
            str3 = "";
        } else {
            str3 = "" + this.M.trim();
        }
        boolean z18 = !TextUtils.isEmpty(this.K);
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (z18) {
            hashMap2.put("contentHasTitle", "1");
            str3 = this.K.trim() + "\n" + str3.trim();
            this.M = str3;
        } else {
            hashMap2.put("contentHasTitle", "0");
        }
        try {
            hashMap2.put("xsj_picture_num", WinkDatongCurrentParams.get("xsj_picture_num").toString());
            hashMap2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM).toString());
        } catch (Exception e16) {
            w53.b.e(N0, e16);
        }
        a2(hashMap2);
        MusicParams k3 = k3();
        X1(hashMap2);
        FeedParams.Builder withSaveMedia = builder.withContent(str3).withSyncToQzone(z16).withNearByRecommend(true).withSaveMedia(z17);
        if (s26 != null) {
            str4 = s26;
        }
        withSaveMedia.withScheme(str4).withAdvJobId(str2).withPublic(M1).withMusic(k3).withPoi(l3(basePartFragment)).withPromotion(m3(basePartFragment)).withSchool(n3(basePartFragment)).withType(this.Y.getValue().intValue()).withBusinessShare(f3()).withRequestExtInfo(hashMap).withNotAllowDownload(E2()).withActivityItemValue(t2()).withLiteBanner(j2(basePartFragment)).withExtInfo(h3(hashMap2)).withDeclarationParams(h2()).withFeedExtraInfo(b2(basePartFragment));
        return builder.build();
    }

    private LiteBanner j2(BasePartFragment basePartFragment) {
        try {
            String string = basePartFragment.getActivity().getIntent().getExtras().getString(WinkDaTongReportConstant.ElementParamKey.XSJ_KEY_STATUS_SYNC_INFO, "");
            if (string.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            LiteBanner liteBanner = new LiteBanner();
            if (jSONObject.keys().hasNext()) {
                String str = (String) jSONObject.keys().next();
                liteBanner.getExtInfo().put(str, jSONObject.optString(str));
            }
            return liteBanner;
        } catch (Exception e16) {
            w53.b.c(N0, "[getLiteBanner] " + e16.toString());
            return null;
        }
    }

    private List<MediaParams> j3() {
        ArrayList<WinkPublishMediaRecord> arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            LocalMediaInfo localMediaInfo = this.D.get(i3);
            if (this.A0.size() > i3) {
                arrayList = this.A0.get(i3);
            } else {
                arrayList = null;
            }
            if (AlbumUtil.isImage(localMediaInfo)) {
                arrayList2.add(ImageParams.INSTANCE.from(localMediaInfo, arrayList));
            } else if (AlbumUtil.isVideo(localMediaInfo)) {
                VideoParams from = VideoParams.INSTANCE.from(localMediaInfo, arrayList);
                WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(i2());
                if (d16 != null && d16.getOriginMediaInfos() != null) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<LocalMediaInfo> it = com.tencent.mobileqq.wink.editor.draft.c.n(d16).iterator();
                    while (it.hasNext()) {
                        LocalMediaInfo next = it.next();
                        if (next != null) {
                            arrayList3.add(VideoParams.INSTANCE.from(next, null));
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        from.setOriginVideoParams(arrayList3);
                    }
                }
                arrayList2.add(from);
            }
        }
        return arrayList2;
    }

    private int k2(BasePartFragment basePartFragment) {
        Intent intent;
        FragmentActivity activity = basePartFragment.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        return intent.getIntExtra(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE, 0);
    }

    private MusicParams k3() {
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.f326008i0)) {
            long j3 = this.f326009j0;
            String str3 = this.f326008i0;
            String str4 = this.f326010k0;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            long j16 = this.f326011l0;
            int i3 = this.f326014n0;
            String str5 = this.f326015o0;
            if (str5 == null) {
                str2 = "";
            } else {
                str2 = str5;
            }
            return new MusicParams(j3, str3, str, j16, i3, str2);
        }
        return null;
    }

    private int l2(BasePartFragment basePartFragment, String str) {
        Intent intent;
        FragmentActivity activity = basePartFragment.getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        return intent.getIntExtra(str, 0);
    }

    @Nullable
    private PoiParams l3(BasePartFragment basePartFragment) {
        LbsDataV2.PoiInfo poiInfo = ((o) basePartFragment.getViewModel(o.class)).G;
        PartsStateViewModel partsStateViewModel = (PartsStateViewModel) basePartFragment.getViewModel(PartsStateViewModel.class);
        boolean isSelected = partsStateViewModel.i2().getValue().getIsSelected();
        boolean selectable = partsStateViewModel.i2().getValue().getSelectable();
        boolean visible = partsStateViewModel.i2().getValue().getVisible();
        w53.b.a(N0, "[preparePoiParams]:isSelectedAble:" + selectable + ",isSelected:" + isSelected + ",isVisible:" + visible);
        if (selectable && isSelected && visible && poiInfo != null) {
            return PoiParams.fromPoiInfo(poiInfo);
        }
        return null;
    }

    @Nullable
    private PromotionPublishParams m3(BasePartFragment basePartFragment) {
        PublishPromotionViewModel publishPromotionViewModel = (PublishPromotionViewModel) basePartFragment.getViewModel(PublishPromotionViewModel.class);
        PartsStateViewModel partsStateViewModel = (PartsStateViewModel) basePartFragment.getViewModel(PartsStateViewModel.class);
        Pair<PromotionParams, PublishPromotionViewModel.PromotionSource> value = publishPromotionViewModel.c2().getValue();
        boolean isSelected = partsStateViewModel.g2().getValue().getIsSelected();
        boolean selectable = partsStateViewModel.g2().getValue().getSelectable();
        boolean visible = partsStateViewModel.g2().getValue().getVisible();
        w53.b.a(N0, "[preparePromotionParams]:isSelectedAble:" + selectable + ",isSelected:" + isSelected + ",isVisible:" + visible);
        if (selectable && isSelected && visible && value != null) {
            return value.getFirst().covertToPublishParams();
        }
        return null;
    }

    @Nullable
    private SchoolParams n3(BasePartFragment basePartFragment) {
        String value = this.f326007i.getValue();
        PartsStateViewModel partsStateViewModel = (PartsStateViewModel) basePartFragment.getViewModel(PartsStateViewModel.class);
        boolean isSelected = partsStateViewModel.l2().getValue().getIsSelected();
        boolean selectable = partsStateViewModel.l2().getValue().getSelectable();
        boolean visible = partsStateViewModel.l2().getValue().getVisible();
        w53.b.a(N0, "[prepareSchoolParams]:isSelectedAble:" + selectable + ",isSelected:" + isSelected + ",isVisible:" + visible);
        if (selectable && isSelected && visible && !TextUtils.isEmpty(value)) {
            return new SchoolParams(value);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cb, code lost:
    
        switch(r13) {
            case 0: goto L77;
            case 1: goto L76;
            case 2: goto L75;
            case 3: goto L74;
            case 4: goto L73;
            case 5: goto L72;
            case 6: goto L71;
            case 7: goto L70;
            case 8: goto L75;
            default: goto L80;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
    
        r4.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
    
        r6.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
    
        r0.add(r9);
        w53.b.f("CircleTakeSame", java.lang.String.format("generateDatongParams---materialId=%s", r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        r5.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f5, code lost:
    
        r2.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fa, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ff, code lost:
    
        com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams.params.put(com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_APPLY_SCOPE, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0109, code lost:
    
        r3.add(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o3(ArrayList<ArrayList<WinkPublishMediaRecord>> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        Iterator<ArrayList<WinkPublishMediaRecord>> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<WinkPublishMediaRecord> it5 = it.next().iterator();
            while (it5.hasNext()) {
                WinkPublishMediaRecord next = it5.next();
                if (next.mediaType != null) {
                    String mediaIdStr = next.getMediaIdStr();
                    String str = next.mediaType;
                    str.hashCode();
                    char c16 = '\uffff';
                    switch (str.hashCode()) {
                        case -1890252483:
                            if (str.equals("sticker")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -1819282739:
                            if (str.equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_FILTER_SCOPE)) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case -1321546630:
                            if (str.equals("template")) {
                                c16 = 2;
                                break;
                            }
                            break;
                        case -1274492040:
                            if (str.equals("filter")) {
                                c16 = 3;
                                break;
                            }
                            break;
                        case -737758889:
                            if (str.equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_TTS_NAME)) {
                                c16 = 4;
                                break;
                            }
                            break;
                        case -445885909:
                            if (str.equals("meterial")) {
                                c16 = 5;
                                break;
                            }
                            break;
                        case -74736922:
                            if (str.equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_TTS_VOLUME)) {
                                c16 = 6;
                                break;
                            }
                            break;
                        case 3556653:
                            if (str.equals("text")) {
                                c16 = 7;
                                break;
                            }
                            break;
                        case 2044886559:
                            if (str.equals("libTemplate")) {
                                c16 = '\b';
                                break;
                            }
                            break;
                    }
                }
            }
        }
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PROPS_NAME, TextUtils.join(",", arrayList2));
        WinkDatongCurrentParams.params.put("xsj_template_name", TextUtils.join(",", arrayList3));
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, TextUtils.join(",", arrayList4));
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PASTE_NAME, TextUtils.join(",", arrayList5));
        WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_TEXT_NAME, TextUtils.join(",", arrayList6));
        if (!arrayList7.isEmpty()) {
            WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME, TextUtils.join(",", arrayList7));
        }
        if (!arrayList8.isEmpty()) {
            WinkDatongCurrentParams.params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_VALUE, TextUtils.join(",", arrayList8));
        }
    }

    private HashMap<String, String> r2(Intent intent) {
        return (HashMap) intent.getSerializableExtra("key_attrs");
    }

    private String s2() {
        List<ha3.b> value;
        if (!TextUtils.isEmpty(this.f326023w0)) {
            return this.f326023w0;
        }
        LiveData<List<ha3.b>> liveData = this.H;
        ha3.b bVar = null;
        if (liveData == null) {
            value = null;
        } else {
            value = liveData.getValue();
        }
        if (value != null && value.size() > 0) {
            bVar = value.get(0);
        }
        String schemaString = WinkContext.INSTANCE.d().getSchemaString();
        this.f326023w0 = schemaString;
        if (TextUtils.isEmpty(schemaString) && bVar != null) {
            this.f326023w0 = bVar.f404635t.get("key_scheme");
        }
        return this.f326023w0;
    }

    private String t2() {
        HashMap<String, String> hashMap = this.Z;
        if (hashMap != null && hashMap.containsKey(QCircleScheme.AttrQQPublish.TIANSHU_ACTIVITY_ITEM_VALUE)) {
            return this.Z.get(QCircleScheme.AttrQQPublish.TIANSHU_ACTIVITY_ITEM_VALUE);
        }
        return "";
    }

    private void v3(BasePartFragment basePartFragment, int i3, String str, boolean z16) {
        String str2;
        String str3 = N0;
        w53.b.f(str3, String.format("[savePublishContent] from=%s, clientKey=%s, saveContent=%s", Integer.valueOf(i3), str, Boolean.valueOf(z16)));
        PartsStateViewModel partsStateViewModel = (PartsStateViewModel) basePartFragment.getViewModel(PartsStateViewModel.class);
        c.a aVar = new c.a(i2(), i3, n2(), m2());
        String str4 = "";
        if (!z16) {
            str2 = "";
        } else {
            str2 = this.K;
        }
        c.a T = aVar.T(str2);
        if (z16) {
            str4 = this.M;
        }
        c.a J = T.F(str4).R(((r) basePartFragment.getViewModel(r.class)).f326066m).I(this.f326003e0).D(str).L(((o) basePartFragment.getViewModel(o.class)).N1()).S(this.f326022v0).E(this.f326005g0).N(((n) basePartFragment.getViewModel(n.class)).M1()).Q(this.f326007i.getValue()).K(this.Y.getValue().intValue()).P(partsStateViewModel.l2().getValue().getIsSelected()).J(partsStateViewModel.l2().getValue().getVisible());
        Pair<PromotionParams, PublishPromotionViewModel.PromotionSource> value = ((PublishPromotionViewModel) basePartFragment.getViewModel(PublishPromotionViewModel.class)).c2().getValue();
        if (value != null && value.getFirst() != null) {
            J.M(value.getFirst());
        }
        J.B(this.f326024x0);
        J.C(this.f326025y0);
        J.O(this.f326023w0);
        J.H(this.L0);
        if (this.G0 != null) {
            w53.b.f(str3, "[savePublishContent] feedBindTroopInfo=" + this.G0);
        }
        PublishTroopViewModel.TroopInfo troopInfo = this.G0;
        if (troopInfo != null) {
            J.V(troopInfo.getTroopId());
            J.W(this.G0.getTroopName());
            J.U(this.G0.getTroopIconUrl());
        }
        WinkDraftUtil.n(J.A());
        PublishViewModelExtKt.b(this);
    }

    private boolean z2() {
        if (this.f326018r0 == 7) {
            return true;
        }
        return false;
    }

    private WinkPublishParams z3(BasePartFragment basePartFragment, boolean z16) {
        boolean z17;
        String str;
        boolean z18;
        String uuid = UUID.randomUUID().toString();
        FeedParams i3 = i3(basePartFragment, uuid);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_publish_use_hd_upload", J2());
        WinkContext.Companion companion = WinkContext.INSTANCE;
        bundle.putString(QQWinkConstants.MISSION_ID, companion.d().getMissionId());
        boolean z19 = false;
        if (!M2(basePartFragment) && !z2()) {
            z17 = true;
        } else {
            z17 = false;
        }
        bundle.putBoolean(QQWinkConstants.NEED_SAVE_TO_DRAFT_BOX, z17);
        bundle.putString("taskid", f2());
        bundle.putString(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, g2());
        bundle.putString(QQWinkConstants.PUBLISH_TRANS_PARAMS_CAMERA_SESSION_ID, companion.d().getDtParams().c());
        String p16 = companion.d().p(QQWinkConstants.WINK_PUBLISH_TASK_ID);
        if (TextUtils.isEmpty(p16)) {
            p16 = companion.d().p(QQWinkConstants.WINK_PUBLISH_TASK_ID.toLowerCase());
        }
        bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, p16);
        String str2 = "0";
        if (!((r) basePartFragment.getViewModel(r.class)).f326066m) {
            str = "0";
        } else {
            str = "1";
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, str);
        if (this.H0) {
            str2 = "1";
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SAVE, str2);
        bundle.putInt(QQWinkConstants.KEY_MATE_ACTIVITY_TYPE, k2(basePartFragment));
        bundle.putString("publish_trans_tag", companion.d().p("publish_trans_tag"));
        String str3 = QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE;
        bundle.putString(str3, this.f326017q0.getStringExtra(str3));
        bundle.putInt(QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID, l2(basePartFragment, QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID));
        bundle.putInt(QQWinkConstants.KEY_MATE_YUHENG_TASK_ID, l2(basePartFragment, QQWinkConstants.KEY_MATE_YUHENG_TASK_ID));
        bundle.putInt(QQWinkConstants.KEY_MATE_YUHENG_RULE_ID, l2(basePartFragment, QQWinkConstants.KEY_MATE_YUHENG_RULE_ID));
        if (L2()) {
            bundle.putString(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE, companion.d().p(QCircleScheme.AttrQQPublish.ST_POST_POST_TYPE));
            bundle.putString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_ID, companion.d().p(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_ID));
            bundle.putString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_POSTER_ID, companion.d().p(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_POSTER_ID));
            bundle.putString(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_CREATETIME, companion.d().p(QCircleScheme.AttrQQPublish.FEED_ABSTRACT_CREATETIME));
            bundle.putString(QCircleScheme.AttrQQPublish.ST_POST_COMMENT_ID, companion.d().p(QCircleScheme.AttrQQPublish.ST_POST_COMMENT_ID));
            bundle.putString(QCircleScheme.AttrQQPublish.ST_POST_REPLY_ID, companion.d().p(QCircleScheme.AttrQQPublish.ST_POST_REPLY_ID));
            bundle.putString(QCircleScheme.AttrQQPublish.COMMENT_DRAFT_ID, companion.d().p(QCircleScheme.AttrQQPublish.COMMENT_DRAFT_ID));
        }
        bundle.putString(QQWinkConstants.EXT_WINK_PUBLISH_CONTENT_PREVIEW, this.M);
        bundle.putBoolean("qcircle_publish_need_fake_progress", true);
        bundle.putBoolean("qcircle_publish_show_notification", true);
        WinkPublishParams winkPublishParams = new WinkPublishParams(1, uuid, this.f326005g0, z16, 23, j3(), g3(), i3, bundle, companion.d().getDtParams().a());
        if (z16) {
            try {
                Parcel obtain = Parcel.obtain();
                winkPublishParams.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                WinkPublishParams createFromParcel = WinkPublishParams.CREATOR.createFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                bundle.putParcelable("qcircle_wink_task_launch_params", createFromParcel);
            } catch (Exception e16) {
                com.tencent.xaction.log.b.c(N0, 1, "[sendTask] ", e16);
            }
            z18 = true;
            WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId("E_PUBLIC_EXIT_NORMAL").traceId(this.f326005g0).ext2(String.valueOf(this.D.size())).getReportData(), 1);
        } else {
            z18 = true;
        }
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService != null) {
            long j3 = this.f326022v0;
            if (j3 < 0) {
                TaskInfo a16 = com.tencent.mobileqq.wink.utils.p.a(qfsService, winkPublishParams);
                String str4 = N0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendTask, find repeat publish feed: ");
                if (a16 != null) {
                    z19 = z18;
                }
                sb5.append(z19);
                w53.b.f(str4, sb5.toString());
                if (a16 == null) {
                    a16 = qfsService.addTask(winkPublishParams);
                }
                if (a16 != null) {
                    this.f326022v0 = a16.getTaskId();
                }
            } else if (!qfsService.updateTaskWithId(j3, winkPublishParams)) {
                w53.b.c(N0, "[sendTask] no task updated, add new again");
                TaskInfo addTask = qfsService.addTask(winkPublishParams);
                if (addTask != null) {
                    this.f326022v0 = addTask.getTaskId();
                }
            }
            w53.b.f(N0, "[sendTask] pre upload task id: " + this.f326022v0);
        } else {
            w53.b.c(N0, "[sendTask] invalid service");
            if (z16) {
                ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        PublishViewModel.this.S2();
                    }
                }, 128, null, false);
                if (WinkPublishServiceProxy2.getInitError() && uq3.c.K6()) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToastUtil.showQQToast(1, "\u82e5\u53d1\u5e03\u5931\u8d25\uff0c\u53ef\u4ee5\u91cd\u542f\u624b\u673a\u8bd5\u8bd5");
                        }
                    });
                }
                if ("1".equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_publish_qipc_open", "1"))) {
                    QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(QQWinkConstants.MMKV_QCIRLE_PUBLISH_TASK, winkPublishParams);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel.3

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* renamed from: com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel$3$a */
                        /* loaded from: classes21.dex */
                        public class a implements EIPCResultCallback {
                            a() {
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public /* synthetic */ void b(EIPCResult eIPCResult) {
                                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setTraceId(PublishViewModel.this.f326005g0).setKeyEventId("E_PUBLISH_ADD_TASK").setKeyRetCode(Long.valueOf(eIPCResult.code)));
                            }

                            @Override // eipc.EIPCResultCallback
                            public void onCallback(final EIPCResult eIPCResult) {
                                w53.b.f(PublishViewModel.N0, "EIPCResult:" + eIPCResult.code);
                                ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ah
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        PublishViewModel.AnonymousClass3.a.this.b(eIPCResult);
                                    }
                                }, 128, null, false);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            QIPCClientHelper.getInstance().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_ADD_PUBLISH_TASK, new Bundle(), new a());
                        }
                    }, 16, null, false);
                }
            }
        }
        return winkPublishParams;
    }

    public boolean A2() {
        return "1".equals(WinkContext.INSTANCE.d().p(QQWinkConstants.KEY_IS_FROM_FRIEND_FIRST_PUBLISH));
    }

    public void A3(boolean z16) {
        this.f326004f0 = z16;
    }

    public boolean B2() {
        if (this.f325999a0 == 24) {
            return true;
        }
        return false;
    }

    public boolean C2() {
        if (this.f325999a0 == 10) {
            return true;
        }
        return false;
    }

    public void C3(String str) {
        this.M = str;
    }

    public boolean D2() {
        return "4".equals(this.f326021u0);
    }

    public void D3(boolean z16) {
        this.N = z16;
        U1();
    }

    public boolean E2() {
        return this.X;
    }

    public void E3(boolean z16) {
        this.X = z16;
    }

    public boolean F2(String str) {
        if (!((IAEResUtil) QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE)) {
            w53.b.a(N0, "isPtuReady... checkAEResVersionOK not OK");
            return false;
        }
        return true;
    }

    public void F3(int i3) {
        this.Y.postValue(Integer.valueOf(i3));
    }

    public boolean G2() {
        x2();
        if (x2() && QzoneConfig.isNotSkipMagicStudioSafeCheck()) {
            return true;
        }
        return false;
    }

    public void G3(String str) {
        this.K = str;
    }

    public boolean H2() {
        return this.W;
    }

    public void H3(boolean z16) {
        this.V = z16;
        ((IWinkExport) QRoute.api(IWinkExport.class)).setHDMode(i2(), Boolean.valueOf(this.V));
    }

    public boolean I2() {
        return this.f326026z0;
    }

    public boolean J2() {
        return this.V;
    }

    public boolean K2() {
        LocalMediaInfo localMediaInfo;
        if (this.D.isEmpty() || (localMediaInfo = this.D.get(0)) == null || !com.tencent.mobileqq.wink.publish.util.c.i(localMediaInfo.mMimeType)) {
            return false;
        }
        return true;
    }

    public boolean L2() {
        if (QCircleWinkOutputRouterForVideoComment.ROUTE_PATH.equals(WinkContext.INSTANCE.d().p("wink_output_route")) && !TextUtils.isEmpty(this.P)) {
            return true;
        }
        return false;
    }

    public void R1(ArrayList<LocalMediaInfo> arrayList) {
        this.D.addAll(arrayList);
        this.C.postValue(this.D);
        U1();
    }

    public void S1() {
        w53.b.f(N0, "cancelPreUpload...");
        WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(1);
        if (service != null) {
            long j3 = this.f326022v0;
            if (j3 > 0) {
                service.cancelTaskWithId(j3);
            }
        }
        this.f326022v0 = -1L;
    }

    public void U1() {
        if (!TextUtils.isEmpty(this.K) && this.L) {
            this.F.postValue(Boolean.FALSE);
        } else if (!TextUtils.isEmpty(this.M) && this.N) {
            this.F.postValue(Boolean.FALSE);
        } else {
            this.F.postValue(Boolean.valueOf(!this.D.isEmpty()));
        }
    }

    public void W1() {
        Iterator<LocalMediaInfo> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().aiTextLabel = null;
        }
    }

    public void a3(int i3, int i16) {
        this.D.add(i16, this.D.remove(i3));
    }

    public FeedExtraInfo b2(BasePartFragment basePartFragment) {
        int i3;
        if (basePartFragment.getActivity() != null) {
            i3 = basePartFragment.getActivity().getIntent().getIntExtra("key_publish_feed_channel", -1);
        } else {
            i3 = -1;
        }
        com.tencent.xaction.log.b.a(N0, 1, "genFeedExtraInfo, pubFeedChannel: " + i3);
        if (i3 != -1) {
            return new FeedExtraInfo(i3);
        }
        return null;
    }

    public void b3() {
        SimpleEventBus.getInstance().dispatchEvent(new WinkSaveEditDraftEvent());
    }

    public ArrayList<String> c2() {
        ArrayList<String> arrayList = new ArrayList<>();
        Observable.from(this.D).filter(new Func1() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.af
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                Boolean N2;
                N2 = PublishViewModel.N2((LocalMediaInfo) obj);
                return N2;
            }
        }).flatMap(new Func1() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ag
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                Observable O2;
                O2 = PublishViewModel.O2((LocalMediaInfo) obj);
                return O2;
            }
        }).subscribe(new ae(arrayList));
        w53.b.a(N0, "[getAiTextFlatList] aiTexts=" + arrayList);
        return arrayList;
    }

    public void c3(Activity activity) {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady()) {
            return;
        }
        if (this.D.isEmpty()) {
            w53.b.g(N0, "[onClickEditVideoCover] empty mediaInfos");
            return;
        }
        LocalMediaInfo localMediaInfo = this.D.get(0);
        Intent intent = new Intent();
        intent.putExtra(WinkHostConstants.AEEditorConstants.keyVideoMediaPath(), localMediaInfo.path);
        intent.putExtra(QQWinkConstants.MISSION_ID, localMediaInfo.missionID);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.f326005g0);
        intent.putExtra(WinkHostConstants.AEEditorConstants.keyVideoCoverPosition(), localMediaInfo.thumbnailProgress);
        intent.putExtra(WinkHostConstants.AEEditorConstants.keyVideoCoverPath(), localMediaInfo.thumbnailPath);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(AEEditorConstants.KEY_IS_VIDEO_PROGRESS_COVER, localMediaInfo.isProgressThumbnail);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo);
        intent.putParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA, arrayList);
        com.tencent.mobileqq.wink.publish.util.c.g(activity, intent, 8);
    }

    public boolean d2() {
        return this.f326004f0;
    }

    public void d3(Activity activity, int i3) {
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.MISSION_ID, i2());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.f326005g0);
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, this.D);
        intent.putExtra(FSPublishConstants.PREVIEW_START_POSITION, i3);
        intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_LOCAL_PATH, this.f326016p0);
        intent.putExtra(QQWinkConstants.PUBLISH_MUSIC_START_TIME, this.f326011l0);
        com.tencent.mobileqq.wink.publish.util.c.h(activity, intent);
    }

    public void e3(Activity activity) {
        if (!((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady()) {
            return;
        }
        if (this.D.isEmpty()) {
            w53.b.g(N0, "[onClickViewPreview] empty mediaInfos");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.MISSION_ID, i2());
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.f326005g0);
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(this.D.subList(0, 1)));
        com.tencent.mobileqq.wink.publish.util.c.f(activity, intent, 8);
        T1();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return N0;
    }

    public DeclarationParams h2() {
        List<ha3.b> value;
        ha3.b bVar;
        HashMap<String, String> hashMap;
        if (this.L0 != null) {
            com.tencent.xaction.log.b.a(N0, 1, "getDeclarationParams... declarationParams:" + this.L0);
            return this.L0;
        }
        LiveData<List<ha3.b>> liveData = this.H;
        if (liveData == null) {
            value = null;
        } else {
            value = liveData.getValue();
        }
        if (value != null && !value.isEmpty()) {
            bVar = value.get(0);
        } else {
            bVar = null;
        }
        if (bVar != null && bVar.f404636u != null) {
            com.tencent.xaction.log.b.a(N0, 1, "getDeclarationParams... recovery from new Params:" + bVar.f404636u);
            this.L0 = bVar.f404636u;
        } else if (bVar != null && (hashMap = bVar.f404635t) != null) {
            String str = hashMap.get("declaration_id");
            if (this.L0 == null && !TextUtils.isEmpty(str)) {
                com.tencent.xaction.log.b.a(N0, 1, "getDeclarationParams... recovery from old declaration id:" + str);
                this.L0 = new DeclarationParams(str, "", null, null);
            }
        }
        return this.L0;
    }

    public String i2() {
        return this.f326006h0;
    }

    public HashMap<String, LocalMediaInfo> m2() {
        HashMap<String, LocalMediaInfo> hashMap = new HashMap<>();
        Iterator<LocalMediaInfo> it = this.D.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            hashMap.put(next.path, next);
        }
        return hashMap;
    }

    public ArrayList<String> n2() {
        ArrayList<String> arrayList = new ArrayList<>();
        Observable.from(this.D).map(new Func1() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ad
            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                String str;
                str = ((LocalMediaInfo) obj).path;
                return str;
            }
        }).subscribe(new ae(arrayList));
        return arrayList;
    }

    public LiveData<Integer> o2() {
        return this.Y;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        w53.b.a(N0, "onCleared...");
        if (!this.f326020t0) {
            S1();
        }
    }

    public String p2() {
        if (TextUtils.isEmpty(this.P)) {
            return "";
        }
        return this.P + " ";
    }

    public void p3(long j3) {
        WinkDraftUtil.f(j3, i2());
    }

    public int q2() {
        return p2().length();
    }

    public void q3(int i3) {
        this.D.remove(i3);
        this.C.postValue(this.D);
        U1();
    }

    public void r3() {
        WinkPublishServiceProxy2 qfsService;
        if (this.J0 && (qfsService = WinkPublishHelper2.INSTANCE.getQfsService()) != null) {
            qfsService.removeTaskListener(this.K0);
        }
    }

    public void s3() {
        w53.b.f(N0, "resumePreUpload isCanceledByPreview " + this.M0);
        if (this.M0) {
            this.M0 = false;
            this.G.postValue(Boolean.TRUE);
        }
    }

    public void t3(BasePartFragment basePartFragment, int i3) {
        w3(basePartFragment, i3, true);
    }

    public void u2(Intent intent) {
        final String stringExtra = intent.getStringExtra(WinkHostConstants.AEEditorConstants.keyVideoMediaPath());
        final String stringExtra2 = intent.getStringExtra(WinkHostConstants.AEEditorConstants.keyVideoCoverPath());
        final boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.KEY_IS_VIDEO_PROGRESS_COVER, true);
        final float floatExtra = intent.getFloatExtra(WinkHostConstants.AEEditorConstants.keyVideoCoverPosition(), -1.0f);
        w53.b.a(N0, "[handleEditVideoCover] mediaPath=" + stringExtra + ", coverPath=" + stringExtra2 + "progress=" + floatExtra + ", isProgressCover=" + booleanExtra);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            Observable.from(this.D).filter(new Func1() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ab
                @Override // rx.functions.Func1
                public final Object call(Object obj) {
                    Boolean Q2;
                    Q2 = PublishViewModel.Q2(stringExtra, (LocalMediaInfo) obj);
                    return Q2;
                }
            }).subscribe(new Action1() { // from class: com.tencent.mobileqq.wink.publish.viewmodel.ac
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    PublishViewModel.this.R2(stringExtra2, floatExtra, booleanExtra, (LocalMediaInfo) obj);
                }
            });
            this.C.postValue(this.D);
        }
    }

    public void u3(BasePartFragment basePartFragment, int i3, String str) {
        v3(basePartFragment, i3, str, true);
    }

    public boolean v2() {
        String str = this.M;
        if ((str != null && !TextUtils.isEmpty(str.trim())) || !this.D.isEmpty()) {
            return true;
        }
        return false;
    }

    public void w2(@Nullable Intent intent, boolean z16) {
        String p16;
        if (intent == null) {
            w53.b.c(N0, "[initData] invalid intent");
            return;
        }
        this.f326017q0 = intent;
        WinkContext.Companion companion = WinkContext.INSTANCE;
        this.f326005g0 = companion.d().getTraceId();
        this.f326006h0 = companion.d().getMissionId();
        w53.b.f(N0, "[initData] traceId=" + this.f326005g0 + ", missionId=" + this.f326006h0 + ", isOnNewIntent: " + z16);
        this.I0 = intent.getBooleanExtra(QQWinkConstants.IS_IMAGE_MODEL, false);
        this.Z = r2(intent);
        this.f326026z0 = intent.getBooleanExtra(QQWinkConstants.PUBLISH_THROUGH_EXPORT, false);
        this.f326018r0 = intent.getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1);
        this.f326019s0 = intent.getBooleanExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_FROM_TEMPLATE_PAGE, false);
        int intExtra = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
        this.f325999a0 = intExtra;
        if (intExtra <= 0 && (p16 = companion.d().p("up_source")) != null) {
            try {
                this.f325999a0 = Integer.parseInt(p16);
            } catch (Exception e16) {
                w53.b.d(N0, "[initData] upSource=" + p16, e16);
            }
        }
        this.f326000b0 = intent.getIntExtra(WinkHostConstants.AEEditorConstants.videoPhotoFrom(), 2);
        this.f326023w0 = intent.getStringExtra("key_scheme");
        this.f326021u0 = intent.getStringExtra(QQWinkConstants.SCHEMA_TARGET);
        if ("1".equals(WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.SYNC_PUBLISH))) {
            this.J0 = true;
            this.K0 = new a();
        }
        T2(intent);
        Y2(intent);
        U2(intent);
        V2(intent);
        W2(intent);
        w53.b.f(N0, "[initData] mShowHDView: " + this.W + ", mIsFromDraft: " + this.f326018r0 + ", isFromTemplatePage: " + this.f326019s0 + ", mQcircleFromType: " + this.f325999a0 + ", mQcircleUpType: " + this.f326000b0);
        U1();
        this.I.setValue(Boolean.FALSE);
        this.H = WinkDraftUtil.k(WinkCommonUtil.getCurrentAccountLong(), i2());
        Z1(intent);
        WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId("E_PUBLIC_ENTER").traceId(this.f326005g0).ext1(String.valueOf(this.f325999a0)).ext6(WinkReportUtils.isInMultiWindowMode(null)).getReportData(), 1);
        if (!this.D.isEmpty()) {
            this.G.postValue(Boolean.TRUE);
        }
    }

    public void w3(BasePartFragment basePartFragment, int i3, boolean z16) {
        v3(basePartFragment, i3, "", z16);
    }

    public boolean x2() {
        Intent intent = this.f326017q0;
        if (intent == null) {
            return false;
        }
        return QQWinkConstants.WinkTaskRoute.AIGC.equals(intent.getStringExtra(QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE));
    }

    public void x3(BasePartFragment basePartFragment) {
        this.f326020t0 = true;
        WinkPublishParams z36 = z3(basePartFragment, true);
        if (!M2(basePartFragment) && !z2()) {
            u3(basePartFragment, 3, z36.getClientKey());
        }
        WinkDraftUtil.p(WinkCommonUtil.getCurrentAccountLong(), i2(), 1);
        b3();
        if (this.J0) {
            WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
            if (qfsService != null) {
                qfsService.addTaskListener2(this.K0);
                return;
            }
            return;
        }
        this.f326017q0.putExtra("wink_share_result", true);
        this.f326017q0.putExtra(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID, this.f326022v0);
        this.f326017q0.putExtra(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, this.M);
        OutputData a16 = OutputData.INSTANCE.a(64L, this.D, this.f326017q0);
        WinkContext.Companion companion = WinkContext.INSTANCE;
        companion.d().m().k(basePartFragment.getActivity(), a16);
        if (this.f326018r0 == 10) {
            Intent intent = new Intent();
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, companion.d().getTraceId());
            SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, -1, intent), false);
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false), true);
    }

    public boolean y2(BasePartFragment basePartFragment) {
        boolean z16;
        WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(i2());
        if (d16 != null && d16.isFromQzoneText()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if ((Boolean.valueOf(z16).booleanValue() || M2(basePartFragment)) && WinkExportUtils.x(i2()) == null) {
            return false;
        }
        return true;
    }

    public void y3(BasePartFragment basePartFragment) {
        if (NetworkState.isNetSupport() && !this.f326020t0 && K2()) {
            w53.b.f(N0, "sendSilenceMood...");
            WinkPublishParams z36 = z3(basePartFragment, false);
            if (3 != this.f326018r0 && !M2(basePartFragment) && !z2()) {
                u3(basePartFragment, 5, z36.getClientKey());
            }
        }
    }
}
