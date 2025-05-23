package com.tencent.qqnt.richui.api.impl;

import com.tencent.android.androidbypass.richui.c;
import com.tencent.qqnt.richui.api.IRichUIFactoryApi;
import com.tencent.qqnt.richui.d;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/richui/api/impl/RichUIFactoryApiImpl;", "Lcom/tencent/qqnt/richui/api/IRichUIFactoryApi;", "Lcom/tencent/android/androidbypass/richui/c;", "getRichUIFactory", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichUIFactoryApiImpl implements IRichUIFactoryApi {
    @Override // com.tencent.qqnt.richui.api.IRichUIFactoryApi
    public c getRichUIFactory() {
        return new d();
    }
}
