package com.tencent.mobileqq.aio.msg;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.VASGiftSpendCoinItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ai;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "key", "default", "getExtInfoFromExtStr", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/TextGiftElement;", "j2", "i2", "", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W0", "Ljava/lang/String;", AppConstants.Key.COLUMN_EXT_STR, "Lorg/json/JSONObject;", "X0", "Lorg/json/JSONObject;", "getExtJsonObject", "()Lorg/json/JSONObject;", "setExtJsonObject", "(Lorg/json/JSONObject;)V", "extJsonObject", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Y0", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ai extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private String extStr;

    /* renamed from: X0, reason: from kotlin metadata */
    @Nullable
    private JSONObject extJsonObject;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ai$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.ai$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public List<CharSequence> Q() {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("[\u793c\u7269]");
            return arrayListOf;
        }
        return (List) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 5, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ai(targetMsgRecord);
    }

    @Nullable
    public final String getExtInfoFromExtStr(@NotNull String key, @NotNull String r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key, (Object) r56);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r56, "default");
        if (this.extStr != null) {
            try {
                if (this.extJsonObject == null) {
                    this.extJsonObject = new JSONObject(this.extStr);
                }
                JSONObject jSONObject = this.extJsonObject;
                Intrinsics.checkNotNull(jSONObject);
                if (jSONObject.has(key)) {
                    JSONObject jSONObject2 = this.extJsonObject;
                    Intrinsics.checkNotNull(jSONObject2);
                    return jSONObject2.getString(key);
                }
            } catch (Exception unused) {
            }
        }
        return r56;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int i3 = getMsgRecord().msgType;
        if (i3 != 11) {
            if (i3 != 15) {
                return super.getViewType();
            }
            if (isSelf()) {
                return 31;
            }
            return 30;
        }
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            ArrayList<MsgElement> arrayList2 = getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.elements");
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                if (((MsgElement) it.next()).textGiftElement != null) {
                    if (isSelf()) {
                        return 31;
                    }
                    return 30;
                }
            }
        }
        if (isSelf()) {
            return 34;
        }
        return 35;
    }

    @NotNull
    public final String i2() {
        ArrayList<VASGiftSpendCoinItem> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        TextGiftElement j26 = j2();
        if (j26 == null || (arrayList = j26.spendCoins) == null) {
            return "";
        }
        Iterator<VASGiftSpendCoinItem> it = arrayList.iterator();
        long j3 = 0;
        long j16 = 0;
        while (it.hasNext()) {
            int i3 = it.next().coinType;
            if (i3 == 0) {
                j3 += r9.amt;
            } else if (i3 == 1) {
                j16 += r9.amt;
            }
        }
        long j17 = j3 + j16;
        if (j17 == j3) {
            return "gold";
        }
        if (j17 == j16) {
            return "daibi";
        }
        if (j26.price != 0) {
            return "";
        }
        return "free";
    }

    @Nullable
    public final TextGiftElement j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextGiftElement) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        Iterator<MsgElement> it = getMsgRecord().elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next != null && next.elementType == 18) {
                return next.textGiftElement;
            }
        }
        return null;
    }
}
