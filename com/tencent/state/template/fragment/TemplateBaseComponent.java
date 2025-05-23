package com.tencent.state.template.fragment;

import com.tencent.state.VasBaseFragmentComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/template/fragment/TemplateBaseComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "()V", "appId", "", "getAppId", "()I", "value", "", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateBaseComponent extends VasBaseFragmentComponent {
    private final int appId = 1;

    public int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent
    public Object getTag() {
        return Integer.valueOf(getAppId());
    }

    @Override // com.tencent.state.VasBaseFragmentComponent
    public void setTag(Object obj) {
    }
}
