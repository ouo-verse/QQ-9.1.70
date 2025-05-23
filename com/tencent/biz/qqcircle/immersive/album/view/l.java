package com.tencent.biz.qqcircle.immersive.album.view;

import androidx.lifecycle.Observer;
import qqcircle.QQCircleFeedBase$AlbumPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public final /* synthetic */ class l implements Observer {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ QFSPersonalAlbumDetailWidget f84893d;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        this.f84893d.w0((QQCircleFeedBase$AlbumPageData) obj);
    }
}
