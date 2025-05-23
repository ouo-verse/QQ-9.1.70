package com.tencent.mtt.hippy.c.a;

import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.mtt.hippy.c.d;
import com.tencent.mtt.hippy.common.ConstantValue;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends d {
    public b() {
        super(null, 13);
    }

    private void a(@NonNull HippyArray hippyArray) {
        long size = hippyArray.size();
        a((byte) 65);
        this.f337140a.a(size);
        for (int i3 = 0; i3 < size; i3++) {
            a(hippyArray.get(i3));
        }
        a((byte) 36);
        this.f337140a.a(0L);
        this.f337140a.a(size);
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object m() {
        return ConstantValue.Undefined;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object n() {
        return ConstantValue.Null;
    }

    @Override // com.tencent.mtt.hippy.c.e
    protected Object o() {
        return ConstantValue.Hole;
    }

    private void a(@NonNull HippyMap hippyMap) {
        a(PublicAccountH5AbilityPluginImpl.OPENIMG);
        for (String str : hippyMap.keySet()) {
            if (str == this.f337160b) {
                a("null");
            } else {
                a(str);
            }
            a(hippyMap.get(str));
        }
        a((byte) 123);
        this.f337140a.a(r0.size());
    }

    @Override // com.tencent.mtt.hippy.c.d
    public boolean a(Object obj) {
        if (super.a(obj)) {
            return true;
        }
        if (obj instanceof HippyArray) {
            b(obj);
            a((HippyArray) obj);
        } else {
            if (!(obj instanceof HippyMap)) {
                return false;
            }
            b(obj);
            a((HippyMap) obj);
        }
        return true;
    }
}
