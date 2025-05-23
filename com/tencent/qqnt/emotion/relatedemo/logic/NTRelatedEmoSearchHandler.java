package com.tencent.qqnt.emotion.relatedemo.logic;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.protocol.oidb_0xe9c$ImgInfo;
import com.tencent.qqnt.emotion.protocol.oidb_0xe9c$RelatedFaceReq;
import com.tencent.qqnt.emotion.protocol.oidb_0xe9c$ReqBody;
import com.tencent.qqnt.emotion.protocol.oidb_0xe9c$RspBody;
import com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult;
import com.tencent.qqnt.emotion.utils.d;
import com.tencent.qqnt.emotion.utils.e;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020%\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J0\u0010\u0016\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0 H\u0014J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/NTRelatedEmoSearchHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "code", "", Constants.MMCCID, "", "Lcom/tencent/qqnt/emotion/protocol/oidb_0xe9c$ImgInfo;", "imgInfo", "defaultCount", "H2", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "chatMessage", "curType", "I2", "", "", "tagLists", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "markFaceMessage", "eId", EmojiManagerServiceProxy.EPID, "F2", "", "getCommandList", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "msgItem", "J2", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "d", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getApp", "()Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;)V", "e", "a", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTRelatedEmoSearchHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final String f356399f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseQQAppInterface app;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/logic/NTRelatedEmoSearchHandler$a;", "", "", "RELATED_EMOTION_HANDLER", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TAG", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.logic.NTRelatedEmoSearchHandler$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return NTRelatedEmoSearchHandler.f356399f;
            }
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        String name = NTRelatedEmoSearchHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "NTRelatedEmoSearchHandler::class.java).name");
        f356399f = name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTRelatedEmoSearchHandler(@NotNull BaseQQAppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
        }
    }

    private final void F2(List<String> tagLists, MarketFaceElement markFaceMessage, String eId, String epId) {
        if (eId == null) {
            return;
        }
        String faceName = markFaceMessage.faceName;
        if (!TextUtils.isEmpty(faceName)) {
            Intrinsics.checkNotNullExpressionValue(faceName, "faceName");
            tagLists.add(faceName);
        }
        IRuntimeService runtimeService = this.app.getRuntimeService(IEmoticonManagerService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ice::class.java\n        )");
        Emoticon syncFindEmoticonById = ((IEmoticonManagerService) runtimeService).syncFindEmoticonById(epId, eId);
        if (syncFindEmoticonById != null) {
            if (!TextUtils.isEmpty(syncFindEmoticonById.keywords)) {
                try {
                    JSONArray jSONArray = new JSONArray(syncFindEmoticonById.keywords);
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Object obj = jSONArray.get(i3);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) obj;
                        if (!TextUtils.isEmpty(str) && !tagLists.contains(str)) {
                            tagLists.add(str);
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.e("NTRelatedEmoSearchHandler", 4, e16, new Object[0]);
                    }
                }
            }
            if (!TextUtils.isEmpty(syncFindEmoticonById.name) && !tagLists.contains(syncFindEmoticonById.name)) {
                String str2 = syncFindEmoticonById.name;
                Intrinsics.checkNotNullExpressionValue(str2, "emoticon.name");
                tagLists.add(str2);
            }
        }
    }

    private final void G2(int code) {
        if (QLog.isDevelopLevel()) {
            QLog.d("NTRelatedEmoSearchHandler", 4, "handleError: code=:" + code);
        }
        notifyUI(1, false, Integer.valueOf(code));
    }

    private final void H2(List<oidb_0xe9c$ImgInfo> imgInfo, int defaultCount) {
        if (QLog.isDevelopLevel()) {
            QLog.d("NTRelatedEmoSearchHandler", 4, "handleResponse: defaultCount=:" + defaultCount);
        }
        NTRelatedEmotionSearchResult nTRelatedEmotionSearchResult = new NTRelatedEmotionSearchResult();
        nTRelatedEmotionSearchResult.c(defaultCount);
        nTRelatedEmotionSearchResult.d(new ArrayList());
        if (imgInfo != null) {
            for (oidb_0xe9c$ImgInfo oidb_0xe9c_imginfo : imgInfo) {
                NTRelatedEmotionSearchResult.SearchResultItem searchResultItem = new NTRelatedEmotionSearchResult.SearchResultItem();
                ByteStringMicro byteStringMicro = oidb_0xe9c_imginfo.bytes_img_md5.get();
                if (byteStringMicro != null) {
                    searchResultItem.g(byteStringMicro.toStringUtf8());
                }
                ByteStringMicro byteStringMicro2 = oidb_0xe9c_imginfo.bytes_img_down_url.get();
                if (byteStringMicro2 != null) {
                    searchResultItem.k(byteStringMicro2.toStringUtf8());
                }
                ByteStringMicro byteStringMicro3 = oidb_0xe9c_imginfo.bytes_img_other.get();
                if (byteStringMicro3 != null) {
                    searchResultItem.e(byteStringMicro3.toStringUtf8());
                }
                searchResultItem.c(oidb_0xe9c_imginfo.uint32_img_height.get());
                searchResultItem.l(oidb_0xe9c_imginfo.uint32_img_width.get());
                searchResultItem.f(oidb_0xe9c_imginfo.uint64_img_size.get());
                ByteStringMicro byteStringMicro4 = oidb_0xe9c_imginfo.bytes_resource_id.get();
                if (byteStringMicro4 != null) {
                    searchResultItem.j(byteStringMicro4.toStringUtf8());
                }
                List<NTRelatedEmotionSearchResult.SearchResultItem> b16 = nTRelatedEmotionSearchResult.b();
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult.SearchResultItem>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.emotion.relatedemo.NTRelatedEmotionSearchResult.SearchResultItem> }");
                ((ArrayList) b16).add(searchResultItem);
            }
        }
        notifyUI(1, true, nTRelatedEmotionSearchResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I2(AIOMsgItem chatMessage, int curType) {
        PicElement picElement;
        String str;
        String str2;
        MarketFaceElement marketFaceElement;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String str3;
        String replace$default5;
        String str4;
        PicElement picElement2;
        PicElement picElement3;
        oidb_0xe9c$RelatedFaceReq oidb_0xe9c_relatedfacereq = new oidb_0xe9c$RelatedFaceReq();
        ArrayList arrayList = new ArrayList();
        MsgElement firstTypeElement = chatMessage.getFirstTypeElement(2);
        if (firstTypeElement != null) {
            picElement = firstTypeElement.picElement;
        } else {
            picElement = null;
        }
        if (picElement != null) {
            str2 = picElement.md5HexStr;
            String d16 = e.d(picElement);
            Intrinsics.checkNotNullExpressionValue(d16, "getRelatedEmotionReportType(picElement)");
            if (!TextUtils.isEmpty(d16)) {
                oidb_0xe9c_relatedfacereq.uint32_face_type.set(Integer.parseInt(d16));
            } else {
                oidb_0xe9c_relatedfacereq.uint32_face_type.set(0);
            }
            if (!TextUtils.isEmpty(picElement.fileName)) {
                oidb_0xe9c_relatedfacereq.str_uuid.set(picElement.fileName);
            }
            try {
                picElement2 = picElement;
                try {
                    if (!TextUtils.isEmpty(String.valueOf(chatMessage.getMsgRecord().senderUin))) {
                        oidb_0xe9c_relatedfacereq.uint64_from_uin.set(chatMessage.getMsgRecord().senderUin);
                    }
                    if (!TextUtils.isEmpty(String.valueOf(chatMessage.getMsgRecord().peerUin))) {
                        oidb_0xe9c_relatedfacereq.uint64_group_code.set(chatMessage.getMsgRecord().peerUin);
                    }
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isDevelopLevel()) {
                        QLog.e("NTRelatedEmoSearchHandler", 4, e, new Object[0]);
                    }
                    if (curType == 2) {
                    }
                    picElement3 = picElement2;
                    try {
                        String str5 = picElement3.fileUuid;
                        Intrinsics.checkNotNullExpressionValue(str5, "picElement.fileUuid");
                        oidb_0xe9c_relatedfacereq.uint64_file_id.set(Long.parseLong(str5));
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isDevelopLevel()) {
                        }
                        oidb_0xe9c_relatedfacereq.uint64_file_id.set(0L);
                        if (picElement3.picSubType == 4) {
                        }
                        oidb_0xe9c_relatedfacereq.store_id.set(picElement3.storeID);
                        oidb_0xe9c_relatedfacereq.file_uuid.set(picElement3.fileUuid);
                        str = null;
                        oidb_0xe9c_relatedfacereq.uint64_msg_time.set(chatMessage.getMsgRecord().msgTime);
                        if (!TextUtils.isEmpty(str2)) {
                        }
                        if (!TextUtils.isEmpty(str)) {
                        }
                        if (!arrayList.isEmpty()) {
                        }
                        oidb_0xe9c$ReqBody oidb_0xe9c_reqbody = new oidb_0xe9c$ReqBody();
                        oidb_0xe9c_reqbody.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(System.currentTimeMillis())));
                        PBUInt64Field pBUInt64Field = oidb_0xe9c_reqbody.uint64_src_uin;
                        String currentAccountUin = this.app.getCurrentAccountUin();
                        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
                        pBUInt64Field.set(Long.parseLong(currentAccountUin));
                        oidb_0xe9c_reqbody.uint32_src_term.set(3);
                        oidb_0xe9c_reqbody.uint32_aio_type.set(d.c(curType));
                        oidb_0xe9c_reqbody.str_client_ver.set(com.tencent.qqnt.util.b.f362976b.getSubVersion());
                        oidb_0xe9c_reqbody.relatedFaceReqBody.set(oidb_0xe9c_relatedfacereq);
                        sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, oidb_0xe9c_reqbody.toByteArray()));
                    }
                    if (picElement3.picSubType == 4) {
                        String str6 = picElement3.summary;
                        Intrinsics.checkNotNullExpressionValue(str6, "picElement.summary");
                        arrayList.add(str6);
                    }
                    oidb_0xe9c_relatedfacereq.store_id.set(picElement3.storeID);
                    oidb_0xe9c_relatedfacereq.file_uuid.set(picElement3.fileUuid);
                    str = null;
                    oidb_0xe9c_relatedfacereq.uint64_msg_time.set(chatMessage.getMsgRecord().msgTime);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    if (!arrayList.isEmpty()) {
                    }
                    oidb_0xe9c$ReqBody oidb_0xe9c_reqbody2 = new oidb_0xe9c$ReqBody();
                    oidb_0xe9c_reqbody2.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(System.currentTimeMillis())));
                    PBUInt64Field pBUInt64Field2 = oidb_0xe9c_reqbody2.uint64_src_uin;
                    String currentAccountUin2 = this.app.getCurrentAccountUin();
                    Intrinsics.checkNotNullExpressionValue(currentAccountUin2, "app.currentAccountUin");
                    pBUInt64Field2.set(Long.parseLong(currentAccountUin2));
                    oidb_0xe9c_reqbody2.uint32_src_term.set(3);
                    oidb_0xe9c_reqbody2.uint32_aio_type.set(d.c(curType));
                    oidb_0xe9c_reqbody2.str_client_ver.set(com.tencent.qqnt.util.b.f362976b.getSubVersion());
                    oidb_0xe9c_reqbody2.relatedFaceReqBody.set(oidb_0xe9c_relatedfacereq);
                    sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, oidb_0xe9c_reqbody2.toByteArray()));
                }
            } catch (Exception e18) {
                e = e18;
                picElement2 = picElement;
            }
            if (curType == 2 && curType != 3) {
                try {
                    oidb_0xe9c_relatedfacereq.uint64_file_id.set(0L);
                    picElement3 = picElement2;
                } catch (Exception e19) {
                    e = e19;
                    picElement3 = picElement2;
                    if (QLog.isDevelopLevel()) {
                        QLog.e("NTRelatedEmoSearchHandler", 4, e, new Object[0]);
                    }
                    oidb_0xe9c_relatedfacereq.uint64_file_id.set(0L);
                    if (picElement3.picSubType == 4) {
                    }
                    oidb_0xe9c_relatedfacereq.store_id.set(picElement3.storeID);
                    oidb_0xe9c_relatedfacereq.file_uuid.set(picElement3.fileUuid);
                    str = null;
                    oidb_0xe9c_relatedfacereq.uint64_msg_time.set(chatMessage.getMsgRecord().msgTime);
                    if (!TextUtils.isEmpty(str2)) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    if (!arrayList.isEmpty()) {
                    }
                    oidb_0xe9c$ReqBody oidb_0xe9c_reqbody22 = new oidb_0xe9c$ReqBody();
                    oidb_0xe9c_reqbody22.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(System.currentTimeMillis())));
                    PBUInt64Field pBUInt64Field22 = oidb_0xe9c_reqbody22.uint64_src_uin;
                    String currentAccountUin22 = this.app.getCurrentAccountUin();
                    Intrinsics.checkNotNullExpressionValue(currentAccountUin22, "app.currentAccountUin");
                    pBUInt64Field22.set(Long.parseLong(currentAccountUin22));
                    oidb_0xe9c_reqbody22.uint32_src_term.set(3);
                    oidb_0xe9c_reqbody22.uint32_aio_type.set(d.c(curType));
                    oidb_0xe9c_reqbody22.str_client_ver.set(com.tencent.qqnt.util.b.f362976b.getSubVersion());
                    oidb_0xe9c_reqbody22.relatedFaceReqBody.set(oidb_0xe9c_relatedfacereq);
                    sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, oidb_0xe9c_reqbody22.toByteArray()));
                }
            } else {
                picElement3 = picElement2;
                String str52 = picElement3.fileUuid;
                Intrinsics.checkNotNullExpressionValue(str52, "picElement.fileUuid");
                oidb_0xe9c_relatedfacereq.uint64_file_id.set(Long.parseLong(str52));
            }
            if (picElement3.picSubType == 4 && !TextUtils.isEmpty(picElement3.summary)) {
                String str62 = picElement3.summary;
                Intrinsics.checkNotNullExpressionValue(str62, "picElement.summary");
                arrayList.add(str62);
            }
            oidb_0xe9c_relatedfacereq.store_id.set(picElement3.storeID);
            oidb_0xe9c_relatedfacereq.file_uuid.set(picElement3.fileUuid);
            str = null;
        } else {
            if (chatMessage.getMsgRecord().msgType == 17) {
                MsgElement firstTypeElement2 = chatMessage.getFirstTypeElement(11);
                if (firstTypeElement2 != null) {
                    marketFaceElement = firstTypeElement2.marketFaceElement;
                } else {
                    marketFaceElement = null;
                }
                if (marketFaceElement != null) {
                    String str7 = marketFaceElement.emojiId;
                    String valueOf = String.valueOf(marketFaceElement.emojiPackageId);
                    if (str7 != null) {
                        oidb_0xe9c_relatedfacereq.uint32_face_type.set(1);
                        String emoticonImagePath = com.tencent.qqnt.emotion.constant.d.f356212j;
                        Intrinsics.checkNotNullExpressionValue(emoticonImagePath, "emoticonImagePath");
                        replace$default = StringsKt__StringsJVMKt.replace$default(emoticonImagePath, "[epId]", valueOf, false, 4, (Object) null);
                        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "[eId]", str7, false, 4, (Object) null);
                        String bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(replace$default2));
                        String substring = str7.substring(0, 2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        replace$default3 = StringsKt__StringsJVMKt.replace$default("https://i.gtimg.cn/club/item/parcel/item/[eIdSub]/[eId]/[width]_[height]", "[eIdSub]", substring, false, 4, (Object) null);
                        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "[eId]", str7, false, 4, (Object) null);
                        int i3 = marketFaceElement.imageWidth;
                        String str8 = "200";
                        if (i3 == 0) {
                            str3 = "200";
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(i3);
                            str3 = sb5.toString();
                        }
                        replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "[width]", str3, false, 4, (Object) null);
                        int i16 = marketFaceElement.imageHeight;
                        if (i16 != 0) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(i16);
                            str8 = sb6.toString();
                        }
                        str = StringsKt__StringsJVMKt.replace$default(replace$default5, "[height]", str8, false, 4, (Object) null);
                        oidb_0xe9c_relatedfacereq.bytes_emoji_id.set(ByteStringMicro.copyFromUtf8(str7));
                        oidb_0xe9c_relatedfacereq.bytes_package_id.set(ByteStringMicro.copyFromUtf8(valueOf));
                        str2 = bytes2HexStr;
                    } else {
                        str = null;
                        str2 = null;
                    }
                    oidb_0xe9c_relatedfacereq.uint32_width.set(marketFaceElement.imageWidth);
                    oidb_0xe9c_relatedfacereq.uint32_height.set(marketFaceElement.imageHeight);
                    F2(arrayList, marketFaceElement, str7, valueOf);
                }
            }
            str = null;
            str2 = null;
        }
        oidb_0xe9c_relatedfacereq.uint64_msg_time.set(chatMessage.getMsgRecord().msgTime);
        if (!TextUtils.isEmpty(str2)) {
            PBStringField pBStringField = oidb_0xe9c_relatedfacereq.str_img_md5;
            if (str2 != null) {
                str4 = str2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            } else {
                str4 = null;
            }
            pBStringField.set(str4);
        }
        if (!TextUtils.isEmpty(str)) {
            oidb_0xe9c_relatedfacereq.str_url.set(str);
        }
        if (!arrayList.isEmpty()) {
            oidb_0xe9c_relatedfacereq.str_labels.set(arrayList);
        }
        oidb_0xe9c$ReqBody oidb_0xe9c_reqbody222 = new oidb_0xe9c$ReqBody();
        oidb_0xe9c_reqbody222.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(System.currentTimeMillis())));
        PBUInt64Field pBUInt64Field222 = oidb_0xe9c_reqbody222.uint64_src_uin;
        String currentAccountUin222 = this.app.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin222, "app.currentAccountUin");
        pBUInt64Field222.set(Long.parseLong(currentAccountUin222));
        oidb_0xe9c_reqbody222.uint32_src_term.set(3);
        oidb_0xe9c_reqbody222.uint32_aio_type.set(d.c(curType));
        oidb_0xe9c_reqbody222.str_client_ver.set(com.tencent.qqnt.util.b.f362976b.getSubVersion());
        oidb_0xe9c_reqbody222.relatedFaceReqBody.set(oidb_0xe9c_relatedfacereq);
        sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, oidb_0xe9c_reqbody222.toByteArray()));
    }

    public final void J2(@NotNull AIOMsgItem msgItem, int curType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgItem, curType);
        } else {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NTRelatedEmoSearchHandler$searchRelatedEmoticon$1(this, msgItem, curType, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        Set<String> mutableSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            mutableSetOf = SetsKt__SetsKt.mutableSetOf("OidbSvc.0xe9c_1");
            return mutableSetOf;
        }
        return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @NotNull FromServiceMsg res, @NotNull Object data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        if (req != null) {
            str = req.getServiceCmd();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual("OidbSvc.0xe9c_1", str)) {
            oidb_0xe9c$RspBody oidb_0xe9c_rspbody = new oidb_0xe9c$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, oidb_0xe9c_rspbody);
            if (parseOIDBPkg == 0) {
                int i3 = oidb_0xe9c_rspbody.int32_ret_code.get();
                if (i3 == 0) {
                    H2(oidb_0xe9c_rspbody.relatedFaceRspBody.rpt_img_info.get(), oidb_0xe9c_rspbody.relatedFaceRspBody.img_num.get());
                    return;
                } else {
                    G2(i3);
                    return;
                }
            }
            G2(parseOIDBPkg);
        }
    }
}
