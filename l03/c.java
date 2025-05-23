package l03;

import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$Bubble_Rsp;
import com.tencent.mobileqq.vas.bubble.diy.BubbleDiyComu$UserTextInfo;
import com.tencent.qphone.base.util.QLog;
import d03.BubbleDiyData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0019"}, d2 = {"Ll03/c;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uinAndDiyIds", "Ll03/c$a;", "callBack", "", "c", "Lcom/tencent/mobileqq/vas/bubble/diy/BubbleDiyComu$Bubble_Rsp;", "bubbleRsp", "f", "", "Lcom/tencent/mobileqq/vas/bubble/diy/BubbleDiyComu$UserTextInfo;", "lists", "g", "uin", "diyId", "Ld03/a;", "e", "b", "<init>", "()V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, BubbleDiyData> f413607b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f413608c = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Ll03/c$a;", "", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a();
    }

    private final void c(ArrayList<String> uinAndDiyIds, final a callBack) {
        if (uinAndDiyIds.isEmpty()) {
            return;
        }
        new j03.a().b(uinAndDiyIds, new BusinessObserver() { // from class: l03.b
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                c.d(c.this, callBack, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c this$0, a callBack, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        Log.d("DiyDataHandler", "type : " + i3 + " , isSuccess " + z16);
        if (z16 && (obj instanceof BubbleDiyComu$Bubble_Rsp)) {
            this$0.f((BubbleDiyComu$Bubble_Rsp) obj);
            callBack.a();
        }
    }

    private final void f(BubbleDiyComu$Bubble_Rsp bubbleRsp) {
        List<BubbleDiyComu$UserTextInfo> list;
        if (bubbleRsp.ret.get() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("DiyDataHandler", 2, "DiyText...fetch key \u56de\u5305 sso \u6210\u529f \uff0cserver \u5931\u8d25\uff0cret = " + bubbleRsp.ret.get());
                return;
            }
            return;
        }
        if (bubbleRsp.rspcmd_0x01.has() && bubbleRsp.rspcmd_0x01.user_text_info.has() && (list = bubbleRsp.rspcmd_0x01.user_text_info.get()) != null) {
            g(list);
        }
    }

    private final void g(List<BubbleDiyComu$UserTextInfo> lists) {
        for (BubbleDiyComu$UserTextInfo bubbleDiyComu$UserTextInfo : lists) {
            if (bubbleDiyComu$UserTextInfo.text.has() && bubbleDiyComu$UserTextInfo.text_uin.has() && bubbleDiyComu$UserTextInfo.text_id.has()) {
                try {
                    JSONObject jSONObject = new JSONObject(bubbleDiyComu$UserTextInfo.text.get());
                    String str = bubbleDiyComu$UserTextInfo.text_uin.get() + "_" + bubbleDiyComu$UserTextInfo.text_id.get();
                    String optString = jSONObject.optString("diyText");
                    Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"diyText\")");
                    String optString2 = jSONObject.optString("bl");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"bl\")");
                    String optString3 = jSONObject.optString(TtmlNode.TAG_BR);
                    Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"br\")");
                    String optString4 = jSONObject.optString("tl");
                    Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"tl\")");
                    String optString5 = jSONObject.optString(ReportConstant.COSTREPORT_TRANS);
                    Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"tr\")");
                    BubbleDiyData bubbleDiyData = new BubbleDiyData(str, optString, optString2, optString3, optString4, optString5);
                    f413607b.put(bubbleDiyData.getUinAndDiyId(), bubbleDiyData);
                    VipNtMMKV.INSTANCE.getDiyBubbleConfig().encodeString(bubbleDiyData.getUinAndDiyId(), bubbleDiyComu$UserTextInfo.text.get());
                    if (QLog.isColorLevel()) {
                        QLog.i("DiyDataHandler", 2, "onReceive: uinAndDiyId: " + bubbleDiyData.getUinAndDiyId() + ",config: " + bubbleDiyComu$UserTextInfo.text.get());
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DiyDataHandler", 2, "", e16);
                    }
                }
            }
        }
    }

    public void b(@NotNull String uin, @NotNull String diyId, @NotNull a callBack) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(diyId, "diyId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (e(uin, diyId) != null) {
            callBack.a();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uin + "_" + diyId);
        c(arrayList, callBack);
    }

    @Nullable
    public BubbleDiyData e(@NotNull String uin, @NotNull String diyId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(diyId, "diyId");
        String str = uin + "_" + diyId;
        HashMap<String, BubbleDiyData> hashMap = f413607b;
        BubbleDiyData bubbleDiyData = hashMap.get(str);
        if (bubbleDiyData != null) {
            return bubbleDiyData;
        }
        String decodeString = VipNtMMKV.INSTANCE.getDiyBubbleConfig().decodeString(str, "");
        if (decodeString != null) {
            if (decodeString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                JSONObject jSONObject = new JSONObject(decodeString);
                String optString = jSONObject.optString("diyText");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"diyText\")");
                String optString2 = jSONObject.optString("bl");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"bl\")");
                String optString3 = jSONObject.optString(TtmlNode.TAG_BR);
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"br\")");
                String optString4 = jSONObject.optString("tl");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"tl\")");
                String optString5 = jSONObject.optString(ReportConstant.COSTREPORT_TRANS);
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"tr\")");
                BubbleDiyData bubbleDiyData2 = new BubbleDiyData(str, optString, optString2, optString3, optString4, optString5);
                hashMap.put(str, bubbleDiyData2);
                return bubbleDiyData2;
            }
            return null;
        }
        return null;
    }
}
