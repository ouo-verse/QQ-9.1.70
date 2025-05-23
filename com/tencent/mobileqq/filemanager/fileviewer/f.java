package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f208313a;

    /* renamed from: b, reason: collision with root package name */
    private String f208314b;

    /* renamed from: c, reason: collision with root package name */
    private int f208315c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f208316d;

    /* renamed from: e, reason: collision with root package name */
    private int f208317e;

    /* renamed from: f, reason: collision with root package name */
    private int f208318f;

    public f a(Intent intent) {
        this.f208313a = intent.getStringExtra(IProfileProtocolConst.PARAM_TARGET_UIN);
        this.f208314b = intent.getStringExtra("srcDiscGroup");
        this.f208315c = intent.getIntExtra("peerType", 0);
        this.f208316d = intent.getBooleanExtra("rootEntrace", true);
        this.f208317e = intent.getIntExtra(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, 0);
        this.f208318f = intent.getIntExtra("enterfrom", 0);
        return this;
    }

    public boolean b() {
        return this.f208316d;
    }
}
