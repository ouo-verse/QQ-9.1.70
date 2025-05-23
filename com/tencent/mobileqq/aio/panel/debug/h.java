package com.tencent.mobileqq.aio.panel.debug;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.msgservice.k;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.panel.debug.a;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.aio.utils.y;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.emotion.api.IEmosmService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH\u0002J0\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016R\"\u0010%\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020,0&j\b\u0012\u0004\u0012\u00020,`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010*R$\u00100\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010*R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00160&j\b\u0012\u0004\u0012\u00020\u0016`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0012038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u00107R\u0016\u0010:\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010 R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010 \u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/debug/h;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "", "r", "Lcom/tencent/mobileqq/aio/panel/debug/a$e;", "intent", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/panel/debug/a$j;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/panel/debug/a$g;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/aio/panel/debug/a$i;", "G", "", "localId", "serverId", "", "text", "packId", "stickerId", "Lcom/tencent/mobileqq/data/AniStickerInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "y", "D", "H", "Lcom/tencent/mobileqq/aio/panel/debug/a$h;", "B", "t", "w", "e", "I", "getVideoChatType", "()I", "setVideoChatType", "(I)V", "videoChatType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/Emoticon;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", EmojiManagerServiceConstant.PARAMS_EMOTICON_LIST, "Lcom/tencent/mobileqq/data/EmoticonPackage;", tl.h.F, "emoticonPackageList", "i", "smallFaceList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aniStickerList", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "pokeList", "Ljava/lang/String;", "currentPoke", "E", "currentIndex", UserInfo.SEX_FEMALE, "sendCount", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h extends com.tencent.qqnt.aio.baseVM.a<at.c, PanelUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<String> pokeList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String currentPoke;

    /* renamed from: E, reason: from kotlin metadata */
    private int currentIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private int sendCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int videoChatType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Emoticon> emoticonList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<EmoticonPackage> emoticonPackageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Emoticon> smallFaceList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<AniStickerInfo> aniStickerList;

    public h() {
        ArrayList<Emoticon> arrayListOf;
        ArrayList<EmoticonPackage> arrayListOf2;
        ArrayList<Emoticon> arrayListOf3;
        ArrayList<AniStickerInfo> arrayListOf4;
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Emoticon emoticon = new Emoticon();
        emoticon.epId = "231204";
        emoticon.eId = "2d7d2ff5a6f32fd81d43a6fca7ec9796";
        emoticon.encryptKey = "721a5987903150cc";
        emoticon.name = "\u5f00\u5fc3";
        emoticon.width = 200;
        emoticon.height = 200;
        Unit unit = Unit.INSTANCE;
        Emoticon emoticon2 = new Emoticon();
        emoticon2.epId = "231204";
        emoticon2.eId = "f937f81c5a7a2db7145af42dadecfb1b";
        emoticon2.encryptKey = "721a5987903150cc";
        emoticon2.name = "\u68d2";
        emoticon2.width = 200;
        emoticon2.height = 200;
        Emoticon emoticon3 = new Emoticon();
        emoticon3.epId = "10444";
        emoticon3.eId = "b8193e05dd07fe313e88f8725e1a472c";
        emoticon3.encryptKey = "fd0f1a6eacd2a193";
        emoticon3.name = "\u5b50\u4e54\u53fc\u73ab\u7470";
        emoticon3.width = 200;
        emoticon3.height = 200;
        emoticon3.isSound = true;
        Emoticon emoticon4 = new Emoticon();
        emoticon4.epId = "12246";
        emoticon4.eId = "9f72a40cf75c19880459533efebd4c80";
        emoticon4.encryptKey = "32acb8377fd0c974";
        emoticon4.name = "\u65b0\u5e74\u597d";
        emoticon4.width = 200;
        emoticon4.height = 200;
        emoticon4.isSound = true;
        emoticon4.voicePrint = "25|50|100|50|100|50|25";
        emoticon4.backColor = "#19BAFF";
        emoticon4.volumeColor = "#FFFFFF";
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(emoticon, emoticon2, emoticon3, emoticon4);
        this.emoticonList = arrayListOf;
        EmoticonPackage emoticonPackage = new EmoticonPackage();
        emoticonPackage.epId = "231204";
        emoticonPackage.type = 3;
        emoticonPackage.subType = 1;
        emoticonPackage.jobType = 0;
        emoticonPackage.extraFlags = 0;
        emoticonPackage.mobileFeetype = 1;
        emoticonPackage.wordingId = 1L;
        emoticonPackage.status = 2;
        emoticonPackage.supportSize = "[{\"Height\":300,\"Width\":300},{\"Height\":200,\"Width\":200}]";
        emoticonPackage.valid = true;
        emoticonPackage.mark = "QQfamily\u864e\u5e74\u62dc\u5e74\u79d8\u7c4d";
        emoticonPackage.name = "QQfamily\u864e\u5e74\u8868\u60c5\u5305";
        emoticonPackage.aio = true;
        emoticonPackage.businessExtra = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        EmoticonPackage emoticonPackage2 = new EmoticonPackage();
        emoticonPackage2.epId = "10444";
        emoticonPackage2.type = 3;
        emoticonPackage2.subType = 1;
        emoticonPackage2.jobType = 0;
        emoticonPackage2.extraFlags = 0;
        emoticonPackage2.mobileFeetype = 1;
        emoticonPackage2.wordingId = 1L;
        emoticonPackage2.status = 2;
        emoticonPackage2.valid = true;
        emoticonPackage2.mark = "\u7231\u60c5\u516c\u5bd3";
        emoticonPackage2.name = "\u52a8\u6f2b\u539f\u58f0\u7248\u300a\u7231\u60c5\u516c\u5bd3\u300b\uff0c\u641e\u7b11\u800c\u6d6a\u6f2b\u7684\u7231\u60c5\u6545\u4e8b\u3002";
        emoticonPackage2.aio = true;
        emoticonPackage2.businessExtra = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        emoticonPackage2.newSoundEp = false;
        emoticonPackage2.hasSound = true;
        EmoticonPackage emoticonPackage3 = new EmoticonPackage();
        emoticonPackage3.epId = "12246";
        emoticonPackage3.type = 3;
        emoticonPackage3.subType = 1;
        emoticonPackage3.jobType = 0;
        emoticonPackage3.extraFlags = 0;
        emoticonPackage3.mobileFeetype = 1;
        emoticonPackage3.wordingId = 1L;
        emoticonPackage3.status = 2;
        emoticonPackage3.supportSize = "[{\"Height\":300,\"Width\":300},{\"Height\":200,\"Width\":200}]";
        emoticonPackage3.valid = true;
        emoticonPackage3.mark = "\u55b5\u54e9\u4e2a\u94db\u8868\u60c5\u5305";
        emoticonPackage3.name = "\u9e2d\u9e2d\u8d3a\u65b0\u5e74";
        emoticonPackage3.aio = true;
        emoticonPackage3.businessExtra = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        emoticonPackage3.newSoundEp = true;
        emoticonPackage3.hasSound = true;
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(emoticonPackage, emoticonPackage2, emoticonPackage3);
        this.emoticonPackageList = arrayListOf2;
        Emoticon emoticon5 = new Emoticon();
        emoticon5.character = "[\u62dc\u62dc]";
        emoticon5.epId = "11";
        emoticon5.eId = "1";
        emoticon5.jobType = 3;
        emoticon5.name = "\u62dc\u62dc";
        Emoticon emoticon6 = new Emoticon();
        emoticon6.character = "[\u5f97\u610f]";
        emoticon6.epId = "11";
        emoticon6.eId = "8";
        emoticon6.jobType = 3;
        emoticon6.name = "\u5f97\u610f";
        Emoticon emoticon7 = new Emoticon();
        emoticon7.character = "[\u4eb2\u4eb2]";
        emoticon7.epId = "11";
        emoticon7.eId = "22";
        emoticon7.jobType = 3;
        emoticon7.name = "\u4eb2\u4eb2";
        Emoticon emoticon8 = new Emoticon();
        emoticon8.character = "[\u751f\u6c14]";
        emoticon8.epId = "11";
        emoticon8.eId = "24";
        emoticon8.jobType = 3;
        emoticon8.name = "\u751f\u6c14";
        Emoticon emoticon9 = new Emoticon();
        emoticon9.character = "[\u7b11\u7740\u54ed]";
        emoticon9.epId = "11";
        emoticon9.eId = WadlProxyConsts.OPER_TYPE_APK_SIGN;
        emoticon9.jobType = 3;
        emoticon9.name = "\u7b11\u7740\u54ed";
        Emoticon emoticon10 = new Emoticon();
        emoticon10.character = "[\u7728\u773c]";
        emoticon10.epId = "11";
        emoticon10.eId = "40";
        emoticon10.jobType = 3;
        emoticon10.name = "\u7728\u773c";
        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(emoticon5, emoticon6, emoticon7, emoticon8, emoticon9, emoticon10);
        this.smallFaceList = arrayListOf3;
        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(q(9, 5, "/\u6d41\u6cea", "1", "16"), q(311, 311, "/\u6253Call", "1", "1"), q(312, 312, "/\u53d8\u5f62", "1", "2"), q(313, 313, "/\u55d1\u5230\u4e86", "1", "3"), q(314, 314, "/\u4ed4\u7ec6\u5206\u6790", "1", "4"), q(315, 315, "/\u52a0\u6cb9", "1", "5"), q(316, 316, "/\u6211\u6ca1\u4e8b", "1", "6"), q(317, 317, "/\u83dc\u6c6a", "1", "7"), q(318, 318, "/\u5d07\u62dc", "1", "8"));
        this.aniStickerList = arrayListOf4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"[\u6233\u4e00\u6233]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002", "[666]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002", "[\u653e\u5927\u62db]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002", "[\u70b9\u8d5e]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002", "[\u6bd4\u5fc3]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002", "[\u5fc3\u788e]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002"});
        this.pokeList = listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(a.g intent) {
        Iterator<T> it = this.emoticonPackageList.iterator();
        while (it.hasNext()) {
            ((IEmoticonManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEmoticonManagerService.class, "")).saveEmoticonPackage((EmoticonPackage) it.next());
        }
        Emoticon emoticon = this.emoticonList.get(new Random().nextInt(this.emoticonList.size()));
        Intrinsics.checkNotNullExpressionValue(emoticon, "emoticonList[Random().nextInt(emoticonList.size)]");
        ((IEmosmService) QRoute.api(IEmosmService.class)).sendEmoticon(MobileQQ.sMobileQQ.peekAppRuntime(), (com.tencent.aio.api.runtime.a) getMContext(), emoticon, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(a.h intent) {
        ArrayList<MsgElement> arrayListOf;
        H();
        AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 1;
        TextElement textElement = new TextElement();
        msgElement.textElement = textElement;
        textElement.content = this.currentPoke;
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Contact a16 = o.a(r16);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
            e16.F(0L, a16, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.panel.debug.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    h.C(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(int i3, String str) {
        q.d(FrameworkVM.TAG, "[handleSendPoke] result=" + i3 + ", msg=" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        ArrayList<MsgElement> arrayListOf;
        AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        FaceElement faceElement = new FaceElement();
        msgElement.faceElement = faceElement;
        faceElement.faceIndex = 114;
        faceElement.faceText = "/\u7bee\u7403";
        faceElement.faceType = 3;
        faceElement.packId = "1";
        faceElement.stickerId = "13";
        faceElement.randomType = 1;
        msgElement.faceElement.imageType = 1;
        msgElement.faceElement.stickerType = 2;
        msgElement.faceElement.sourceType = 1;
        FaceElement faceElement2 = msgElement.faceElement;
        faceElement2.surpriseId = "";
        faceElement2.resultId = String.valueOf(new Random().nextInt(5) + 1);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Contact a16 = o.a(r16);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
            e16.F(0L, a16, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.panel.debug.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    h.F(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i3, String str) {
        q.d(FrameworkVM.TAG, "[handleSendLottieEmoticon] result=" + i3 + ", msg=" + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(a.i intent) {
        Emoticon emoticon = this.smallFaceList.get(new Random().nextInt(this.smallFaceList.size()));
        Intrinsics.checkNotNullExpressionValue(emoticon, "smallFaceList[Random().n\u2026tInt(smallFaceList.size)]");
        Emoticon emoticon2 = emoticon;
        ((IEmoticonManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IEmoticonManagerService.class, "")).saveEmoticon(emoticon2);
        String str = emoticon2.epId;
        Intrinsics.checkNotNullExpressionValue(str, "emoticon.epId");
        int parseInt = Integer.parseInt(str);
        String str2 = emoticon2.eId;
        Intrinsics.checkNotNullExpressionValue(str2, "emoticon.eId");
        char[] b16 = com.tencent.qqnt.emotion.utils.a.b(parseInt, Integer.parseInt(str2));
        Intrinsics.checkNotNullExpressionValue(b16, "get4CharFromInt(emoticon\u2026(), emoticon.eId.toInt())");
        AIOMsgService.f190196a.z(new k(((com.tencent.aio.api.runtime.a) getMContext()).g().r(), y.d(y.f194180a, new String(new char[]{20, b16[3], b16[2], b16[1], b16[0]}), 0, 0L, 0L, null, 30, null)));
    }

    private final void H() {
        int i3 = this.sendCount;
        this.sendCount = i3 + 1;
        if (i3 > 3) {
            this.sendCount = 1;
            List<String> list = this.pokeList;
            int i16 = this.currentIndex + 1;
            this.currentIndex = i16;
            this.currentPoke = list.get(i16 % list.size());
        }
        if (this.currentPoke == null) {
            List<String> list2 = this.pokeList;
            this.currentPoke = list2.get(this.currentIndex % list2.size());
        }
    }

    private final AniStickerInfo q(int localId, int serverId, String text, String packId, String stickerId) {
        AniStickerInfo build = new AniStickerInfo.Builder().setBasicInfo(1, localId, serverId, text, packId, stickerId).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s\u2026rId)\n            .build()");
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        Contact b16 = o.b(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c());
        String str = b16.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
        LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.b(LocalGrayTip.LocalGrayTipBuilder.i(LocalGrayTip.LocalGrayTipBuilder.l(LocalGrayTip.LocalGrayTipBuilder.d(LocalGrayTip.LocalGrayTipBuilder.d(LocalGrayTip.LocalGrayTipBuilder.i(LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(str, b16.chatType, 51L, 0, true, false, null, 8, null), "text ", 0, 2, null), "long text text text text text text text text text text text text text text text text t", 0, 2, null), "http://tianquan.gtimg.cn/nudgeaction/item/0/expression.jpg", null, null, 6, null), "icon_common", null, null, 6, null), "u_rCvKhqW4H81IySmeF8pZNQ", "ted", null, 0, 12, null), " www.qq.com ", 0, 2, null), "openUrlText", "https://www.qq.com", 0, 4, null).m();
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        iNtGrayTipApi.addLocalGrayTip(peekAppRuntime, m3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(a.j intent) {
        AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        int i3 = this.videoChatType;
        this.videoChatType = i3 + 1;
        int i16 = (i3 % 16) + 1;
        int nextInt = (new Random().nextInt() % 300) + 30;
        IAIOVideoResultApi iAIOVideoResultApi = (IAIOVideoResultApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOVideoResultApi.class);
        Contact b16 = o.b(r16.c());
        long j3 = nextInt;
        if (!intent.a()) {
            currentUid = r16.c().j();
        }
        iAIOVideoResultApi.addLocalAVRecordMsg(b16, new LocalAVRecordElement(i16, j3, currentUid, intent.a() ? 1 : 0, "", "", true, System.currentTimeMillis(), 0));
    }

    private final void t() {
        HashSet<Long> hashSetOf;
        ag l3 = com.tencent.qqnt.msg.f.l();
        if (l3 != null) {
            hashSetOf = SetsKt__SetsKt.hashSetOf(2362919671L, 583900382L);
            l3.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.aio.panel.debug.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                public final void onResult(HashMap hashMap) {
                    h.u(hashMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(HashMap result) {
        QLog.i(FrameworkVM.TAG, 1, "uin to uid: " + result);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (!result.isEmpty()) {
            HashSet<String> hashSet = new HashSet<>();
            Collection values = result.values();
            Intrinsics.checkNotNullExpressionValue(values, "result.values");
            Iterator it = values.iterator();
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
            ag l3 = com.tencent.qqnt.msg.f.l();
            if (l3 != null) {
                l3.getUin(hashSet, new IKernelGetUinInfoCallback() { // from class: com.tencent.mobileqq.aio.panel.debug.g
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
                    public final void onResult(HashMap hashMap) {
                        h.v(hashMap);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HashMap hashMap) {
        QLog.i(FrameworkVM.TAG, 1, "uid to uin: " + hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(a.e intent) {
        boolean endsWith$default;
        boolean endsWith$default2;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(intent.a(), ".mp4", false, 2, null);
        if (!endsWith$default) {
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(intent.a(), ".jpg", false, 2, null);
            if (endsWith$default2) {
                DebugFileSender.f193020a.r(intent.a(), (com.tencent.aio.api.runtime.a) getMContext());
                return;
            } else if (intent.b()) {
                DebugFileSender.f193020a.q(intent.a(), (com.tencent.aio.api.runtime.a) getMContext());
                return;
            } else {
                DebugFileSender.f193020a.p(intent.a(), (com.tencent.aio.api.runtime.a) getMContext());
                return;
            }
        }
        DebugFileSender.f193020a.s(intent.a(), (com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        ArrayList<MsgElement> arrayListOf;
        AniStickerInfo aniStickerInfo = this.aniStickerList.get(new Random().nextInt(this.aniStickerList.size()));
        Intrinsics.checkNotNullExpressionValue(aniStickerInfo, "aniStickerList[Random().\u2026Int(aniStickerList.size)]");
        AniStickerInfo aniStickerInfo2 = aniStickerInfo;
        AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
        MsgElement msgElement = new MsgElement();
        msgElement.elementType = 6;
        FaceElement faceElement = new FaceElement();
        msgElement.faceElement = faceElement;
        faceElement.faceIndex = aniStickerInfo2.sevrId;
        faceElement.faceText = aniStickerInfo2.text;
        faceElement.faceType = 3;
        faceElement.packId = aniStickerInfo2.aniStickerPackId;
        faceElement.stickerId = aniStickerInfo2.aniStickerId;
        faceElement.randomType = 1;
        msgElement.faceElement.imageType = 1;
        msgElement.faceElement.stickerType = Integer.valueOf(aniStickerInfo2.aniStickerType);
        msgElement.faceElement.sourceType = 1;
        FaceElement faceElement2 = msgElement.faceElement;
        faceElement2.surpriseId = "";
        faceElement2.resultId = "";
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Contact a16 = o.a(r16);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
            e16.F(0L, a16, arrayListOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.panel.debug.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    h.z(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int i3, String str) {
        q.d(FrameworkVM.TAG, "[handleSendLottieEmoticon] result=" + i3 + ", msg=" + str);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.c intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.e) {
            x((a.e) intent);
            return;
        }
        if (intent instanceof a.g) {
            A((a.g) intent);
            return;
        }
        if (intent instanceof a.i) {
            G((a.i) intent);
            return;
        }
        if (intent instanceof a.j) {
            s((a.j) intent);
            return;
        }
        if (intent instanceof a.f) {
            if (!((a.f) intent).a()) {
                y();
                return;
            } else {
                D();
                return;
            }
        }
        if (intent instanceof a.h) {
            B((a.h) intent);
        } else if (intent instanceof a.d) {
            t();
        } else if (intent instanceof a.c) {
            r();
        }
    }
}
