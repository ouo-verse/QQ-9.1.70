package com.tencent.mobileqq.qqexpand.network;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&JF\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H&JH\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0004H&J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0004H&J\"\u0010!\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H&J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010%\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u0004H&J\b\u0010&\u001a\u00020\u000eH&J\b\u0010'\u001a\u00020\u000eH&J\b\u0010(\u001a\u00020\u0006H&J\"\u0010,\u001a\u00020\u00042\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010)2\u0006\u0010+\u001a\u00020\u0006H&J\u001a\u0010-\u001a\u00020\u00042\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010)H&J0\u00102\u001a\u00020\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u00022\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u00100\u001a\u0004\u0018\u00010\u00022\b\u00101\u001a\u0004\u0018\u00010\u0010H&J\u001a\u00104\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u00103\u001a\u00020\u0006H&J\"\u00108\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0001H&\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/network/e;", "", "", "uin", "", "vipInfoOnly", "", "l1", "declaration", "url", "duration", MessageForRichState.SIGN_MSG_FONT_ID, MessageForRichState.SIGN_MSG_FONT_TYPE, "clothesId", "", "C0", "", "reqCookies", "reqCount", "searchKey", "", "ts", "searchKeyMask", "isConfigTag", "G0", "Lcom/tencent/mobileqq/data/MessageRecord;", "message", "d1", "y2", "bFromLoginStep", "q1", "sexType", "tagId", "T1", "m1", "k1", "bOpen", "k0", "H", "updateRedPoint", "z1", "", "reqList", "reqTag", "w1", "U1", "selfUin", "friendUin", "friendNick", "_0xb4cCode", "H0", "uinType", "X", "type", "isSuccess", "data", "notifyUI", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface e {
    void C0(@Nullable String uin, @Nullable String declaration, @Nullable String url, int duration, int fontId, int fontType, int clothesId);

    void G0(@Nullable String uin, @Nullable byte[] reqCookies, int reqCount, @Nullable String searchKey, long ts5, @Nullable String searchKeyMask, boolean isConfigTag);

    void H();

    void H0(@Nullable String selfUin, @Nullable String friendUin, @Nullable String friendNick, @Nullable byte[] _0xb4cCode);

    boolean T1(@Nullable String uin, int sexType, int tagId);

    boolean U1(@Nullable List<Long> reqList);

    void X(@Nullable String uin, int uinType);

    void d1(@Nullable MessageRecord message);

    boolean k0(@Nullable String uin, boolean bOpen);

    boolean k1(@Nullable String uin);

    int l1(@Nullable String uin, boolean vipInfoOnly);

    boolean m1(@Nullable String uin);

    void notifyUI(int type, boolean isSuccess, @Nullable Object data);

    void q1(boolean bFromLoginStep);

    void updateRedPoint();

    boolean w1(@Nullable List<Long> reqList, int reqTag);

    void y2(@Nullable String uin);

    int z1();
}
