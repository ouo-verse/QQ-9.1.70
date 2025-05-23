package com.tencent.qfsmonet.module.operator;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;
import com.tencent.qfsmonet.module.operator.common.MonetOperator;
import com.tencent.qfsmonet.module.operator.common.MonetOperatorData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetYUV2RGBOperator extends MonetOperator {
    static IPatchRedirector $redirector_ = null;
    private static final String OP_TYPE_NAME = "YUV2RGB";

    public MonetYUV2RGBOperator() {
        super(OP_TYPE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qfsmonet.module.operator.common.MonetOperator
    @NonNull
    public ArrayList<MonetOperatorData> getOutput() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList<MonetOperatorData> arrayList = new ArrayList<>();
        arrayList.add(new MonetOperatorData(getType() + "_" + hashCode() + "_output_0", MonetPacketDescriptor.MonetDataFormat.RGBA32F));
        return arrayList;
    }
}
