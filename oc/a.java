package oc;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 **\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0004R\"\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R'\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\t0!j\b\u0012\u0004\u0012\u00020\t`\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Loc/a;", "T", "Lq9/a;", "Lbb/g;", "requestBean", "", "U1", "", "lloc", "", "commentNum", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/qqnt/kernel/api/z;", "Q1", "D", "Ljava/lang/String;", "R1", "()Ljava/lang/String;", "X1", "(Ljava/lang/String;)V", "qzoneId", "E", "P1", "W1", "linkId", UserInfo.SEX_FEMALE, "O1", "setLeftAttachInfo", "leftAttachInfo", "G", "S1", "Z1", "rightAttachInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "H", "Ljava/util/ArrayList;", "T1", "()Ljava/util/ArrayList;", "rightList", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a<T> extends q9.a<T> {

    /* renamed from: D, reason: from kotlin metadata */
    private String qzoneId = "";

    /* renamed from: E, reason: from kotlin metadata */
    private String linkId = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String leftAttachInfo = "";

    /* renamed from: G, reason: from kotlin metadata */
    private String rightAttachInfo = "";

    /* renamed from: H, reason: from kotlin metadata */
    private final ArrayList<Integer> rightList = new ArrayList<>();

    /* renamed from: O1, reason: from getter */
    public final String getLeftAttachInfo() {
        return this.leftAttachInfo;
    }

    /* renamed from: P1, reason: from getter */
    public final String getLinkId() {
        return this.linkId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final z Q1() {
        return com.qzone.reborn.albumx.qzonex.utils.i.b();
    }

    /* renamed from: R1, reason: from getter */
    public final String getQzoneId() {
        return this.qzoneId;
    }

    /* renamed from: S1, reason: from getter */
    public final String getRightAttachInfo() {
        return this.rightAttachInfo;
    }

    public final ArrayList<Integer> T1() {
        return this.rightList;
    }

    public abstract void U1(bb.g requestBean);

    public final void W1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.linkId = str;
    }

    public final void X1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qzoneId = str;
    }

    public final void Z1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rightAttachInfo = str;
    }

    public abstract void a2(String lloc, int commentNum);
}
