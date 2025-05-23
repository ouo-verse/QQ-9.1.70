package com.tencent.mobileqq.guild.api.impl;

import android.view.View;
import com.tencent.biz.o;
import com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildSoftKeyboardObserverImpl implements IGuildSoftKeyboardObserver {
    private com.tencent.biz.o mSoftKeyboardObserver;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements o.a {
        a(IGuildSoftKeyboardObserver.a aVar) {
        }

        @Override // com.tencent.biz.o.a
        public void N1(boolean z16, int i3, int i16) {
            throw null;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver
    public void destroy() {
        com.tencent.biz.o oVar = this.mSoftKeyboardObserver;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSoftKeyboardObserver
    public void newSoftKeyboardObserverImpl(View view, IGuildSoftKeyboardObserver.a aVar) {
        this.mSoftKeyboardObserver = new com.tencent.biz.o(view, new a(aVar), ImmersiveUtils.getStatusBarHeight(view.getContext()) + 160);
    }
}
