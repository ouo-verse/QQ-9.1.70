package com.tencent.biz.qqstory.takevideo.slideshow;

import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TransitionHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, LocalMediaInfo> f94329d;

    /* renamed from: e, reason: collision with root package name */
    private MediaFormat f94330e;

    public TransitionHandler(AppInterface appInterface) {
        super(appInterface);
        this.f94329d = new ConcurrentHashMap<>();
    }

    public LocalMediaInfo D2(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f94329d.get(str);
        }
        return null;
    }

    public MediaFormat E2() {
        return this.f94330e;
    }

    public boolean F2(String str) {
        return this.f94329d.containsKey(str);
    }

    public void G2(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f94329d.remove(str);
        }
    }

    public void H2(String str, LocalMediaInfo localMediaInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "setCatcheMediaInfo path : " + str);
        }
        this.f94329d.put(str, localMediaInfo);
    }

    public void I2(MediaFormat mediaFormat) {
        this.f94330e = mediaFormat;
    }

    public void clear() {
        this.f94330e = null;
        this.f94329d.clear();
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "clearCatcheMediaInfo");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
