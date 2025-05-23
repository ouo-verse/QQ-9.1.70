package c30;

import com.google.gson.annotations.SerializedName;
import com.tencent.aelight.camera.ae.play.AEQuDongConstants;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.AppConstants;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    @SerializedName("AudioList")
    public String audioList;

    @SerializedName("BlockRecReason")
    public String blockRecReason;

    @SerializedName("BusiInfo")
    public C0161a busiInfo;

    @SerializedName("CateName")
    public String cateName;

    @SerializedName("CateOff")
    public String cateOff;

    @SerializedName("CircleUgcRight")
    public String circleUgcRight;

    @SerializedName(AECameraConstants.REQ_FIELD_FONT_CONTENT)
    public String content;

    @SerializedName("ContentFlag")
    public Integer contentFlag;

    @SerializedName("ContentId")
    public Long contentId;

    @SerializedName("CreateTime")
    public Integer createTime;

    @SerializedName("DataType")
    public Integer dataType;

    @SerializedName("EventDetail")
    public b eventDetail;

    @SerializedName("ExtractFrameKey")
    public String extractFrameKey;

    @SerializedName("FeedExt")
    public String feedExt;

    @SerializedName("FingerPrintTime")
    public Integer fingerPrintTime;

    @SerializedName("FirstPublishFlag")
    public Integer firstPublishFlag;

    @SerializedName("Grade")
    public Integer grade;

    @SerializedName("HotSpotEventID")
    public Integer hotSpotEventID;

    @SerializedName("ImportTime")
    public Integer importTime;

    @SerializedName("InTime")
    public Integer inTime;

    @SerializedName("IsRecommend")
    public Integer isRecommend;

    @SerializedName("MachineClassing")
    public String machineClassing;

    @SerializedName("MachineTag")
    public String machineTag;

    @SerializedName("MarioResult")
    public c marioResult;

    @SerializedName("MarioResultCheck")
    public Integer marioResultCheck;

    @SerializedName("ModifyTime")
    public Integer modifyTime;

    @SerializedName("OperationFlag")
    public Integer operationFlag;

    @SerializedName("OperatorTopicInfo")
    public d operatorTopicInfo;

    @SerializedName("PenguinExtJsonInfo")
    public String penguinExtJsonInfo;

    @SerializedName(AEQuDongConstants.INTENT_KEY_PHOTOLIST)
    public String photoList;

    @SerializedName("PubMaterialInfo")
    public String pubMaterialInfo;

    @SerializedName("PublishLocation")
    public String publishLocation;

    @SerializedName("PublishProvince")
    public String publishProvince;

    @SerializedName("Reserve1")
    public String reserve1;

    @SerializedName("ReviewTag")
    public Integer reviewTag;

    @SerializedName("ReviewTime")
    public Integer reviewTime;

    @SerializedName("RowKey")
    public String rowKey;

    @SerializedName("SecurityResult")
    public Integer securityResult;

    @SerializedName("SourceAppId")
    public Integer sourceAppId;

    @SerializedName("SourceItemId")
    public String sourceItemId;

    @SerializedName("Stage")
    public Integer stage;

    @SerializedName("StageTrace")
    public String stageTrace;

    @SerializedName("Status")
    public Integer status;

    @SerializedName("SubCateName")
    public String subCateName;

    @SerializedName("SubCateOff")
    public String subCateOff;

    @SerializedName("Tag")
    public String tag;

    @SerializedName("TextContentCheck")
    public Integer textContentCheck;

    @SerializedName("ThirdCateName")
    public String thirdCateName;

    @SerializedName("Title")
    public String title;

    @SerializedName("TopicId")
    public String topicId;

    @SerializedName("TopicName")
    public String topicName;

    @SerializedName(AppConstants.Key.UID)
    public String uid;

    @SerializedName("UnifiedTag")
    public String unifiedTag;

    @SerializedName("UserInfo")
    public String userInfo;

    @SerializedName("UserSecData")
    public e userSecData;

    @SerializedName("Version")
    public Integer version;

    @SerializedName("VideoList")
    public String videoList;

    /* compiled from: P */
    /* renamed from: c30.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0161a {

        @SerializedName("AMSInfo")
        public C0162a aMSInfo;

        @SerializedName("CircleInfo")
        public b circleInfo;

        /* compiled from: P */
        /* renamed from: c30.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0162a {

            @SerializedName("JobID")
            public Integer jobID;
        }

        /* compiled from: P */
        /* renamed from: c30.a$a$b */
        /* loaded from: classes4.dex */
        public static class b {

            @SerializedName("UpSource")
            public String upSource;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b {

        @SerializedName("EventRes")
        public C0163a eventRes;

        @SerializedName("EventType")
        public Integer eventType;

        /* compiled from: P */
        /* renamed from: c30.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0163a {

            @SerializedName("EventResCode")
            public Integer eventResCode;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c {

        @SerializedName("ColdBootProcessType")
        public Integer coldBootProcessType;

        @SerializedName("SchoolMatchingResult")
        public String schoolMatchingResult;

        @SerializedName("StaticVideoScore")
        public Integer staticVideoScore;

        @SerializedName("YuhengClarity")
        public String yuhengClarity;

        @SerializedName("YuhengPicLogo")
        public String yuhengPicLogo;

        @SerializedName("YuhengPicVulgar")
        public C0164a yuhengPicVulgar;

        @SerializedName("YuhengSecurityCheck")
        public b yuhengSecurityCheck;

        /* compiled from: P */
        /* renamed from: c30.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0164a {

            @SerializedName("MaxVulgarResult")
            public String maxVulgarResult;

            @SerializedName("MaxVulgarScore")
            public String maxVulgarScore;
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        public static class b {

            @SerializedName("bizSecScore")
            public Integer bizSecScore;

            @SerializedName("sealScore")
            public Integer sealScore;

            @SerializedName("secLevel")
            public Integer secLevel;

            @SerializedName("secScore")
            public Integer secScore;

            @SerializedName("secState")
            public Integer secState;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d {

        @SerializedName("OperatrorDelUserTopicId")
        public String operatrorDelUserTopicId;

        @SerializedName("OperatrorDelUserTopicName")
        public String operatrorDelUserTopicName;

        @SerializedName("OperatrorTopicId")
        public String operatrorTopicId;

        @SerializedName("OperatrorTopicName")
        public String operatrorTopicName;
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class e {

        @SerializedName("bizSecScore")
        public Integer bizSecScore;

        @SerializedName("sealScore")
        public Integer sealScore;

        @SerializedName("secState")
        public Integer secState;
    }
}
