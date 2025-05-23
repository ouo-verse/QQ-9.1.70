package lo2;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$SearchTemplateResp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends m {

    /* renamed from: b0, reason: collision with root package name */
    private HeadTemplatePB$SearchTemplateResp f415213b0;

    public h(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        X(ufsResultItem);
    }

    private void X(UfsResultItem ufsResultItem) {
        byte[] bArr = ufsResultItem.layoutContent;
        if (bArr != null && bArr.length > 0) {
            HeadTemplatePB$SearchTemplateResp headTemplatePB$SearchTemplateResp = new HeadTemplatePB$SearchTemplateResp();
            this.f415213b0 = headTemplatePB$SearchTemplateResp;
            try {
                headTemplatePB$SearchTemplateResp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("NetSearchQCircleGameUnionItem", 1, "#parseData", e16);
            }
        }
    }

    @Override // lo2.m
    public boolean N() {
        if (this.f415213b0 != null) {
            return true;
        }
        return false;
    }

    public HeadTemplatePB$SearchTemplateResp W() {
        return this.f415213b0;
    }
}
