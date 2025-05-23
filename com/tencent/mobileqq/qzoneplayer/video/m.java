package com.tencent.mobileqq.qzoneplayer.video;

import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes35.dex */
public class m implements i {

    /* renamed from: a, reason: collision with root package name */
    private s f280010a = s.g();

    /* renamed from: b, reason: collision with root package name */
    private CountDownLatch f280011b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f280012c;

    /* renamed from: d, reason: collision with root package name */
    private int f280013d;

    /* renamed from: e, reason: collision with root package name */
    public String f280014e;

    public m(int i3, CountDownLatch countDownLatch) {
        this.f280011b = countDownLatch;
        this.f280013d = i3;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.i
    public void a(String str, boolean z16, String str2, int i3, int i16) {
        PlayerUtils.log(4, "SegmentVideoUrlCallback", "flag = " + z16 + "oldUrl = " + str);
        this.f280010a.a(str, z16, str2, i3, i16);
        this.f280012c = false;
        this.f280011b.countDown();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.i
    public void b(String str, boolean z16, SegmentVideoInfo.StreamInfo streamInfo, String[] strArr, boolean z17, int i3, boolean z18) {
        ArrayList<SegmentVideoInfo.SegmentInfo> arrayList;
        this.f280012c = z16;
        if (z16 && streamInfo != null && (arrayList = streamInfo.segmentInfos) != null && arrayList.size() > 0) {
            if (this.f280013d > 0) {
                int size = streamInfo.segmentInfos.size();
                int i16 = this.f280013d;
                if (size >= i16) {
                    this.f280014e = streamInfo.segmentInfos.get(i16 - 1).url;
                }
            }
            this.f280014e = streamInfo.segmentInfos.get(0).url;
        }
        this.f280010a.b(str, z16, streamInfo, strArr, z17, i3, z18);
        PlayerUtils.log(4, "SegmentVideoUrlCallback", "flag = " + z16 + ", oldUrl = " + str + ", retryUrl = " + this.f280014e);
        this.f280011b.countDown();
    }
}
