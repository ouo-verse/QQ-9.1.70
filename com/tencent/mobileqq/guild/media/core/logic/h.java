package com.tencent.mobileqq.guild.media.core.logic;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/h;", "Lcom/tencent/mobileqq/guild/media/core/g;", "", "E0", "u", "p", "h0", "", "d", "Z", "hasCalledOnEnter", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class h implements com.tencent.mobileqq.guild.media.core.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasCalledOnEnter;

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        this.hasCalledOnEnter = true;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
        if (!this.hasCalledOnEnter) {
            E0();
        }
        this.hasCalledOnEnter = true;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        this.hasCalledOnEnter = false;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
    }
}
