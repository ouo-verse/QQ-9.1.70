package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class RatingInfo extends JceStruct {
    public static Map<Integer, Long> cache_ratingDistribution;
    public long ratingCount = 0;
    public double averageRating = 0.0d;
    public Map<Integer, Long> ratingDistribution = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ratingCount = jceInputStream.read(this.ratingCount, 0, true);
        this.averageRating = jceInputStream.read(this.averageRating, 1, true);
        if (cache_ratingDistribution == null) {
            cache_ratingDistribution = new HashMap();
            cache_ratingDistribution.put(0, 0L);
        }
        this.ratingDistribution = (Map) jceInputStream.read((JceInputStream) cache_ratingDistribution, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ratingCount, 0);
        jceOutputStream.write(this.averageRating, 1);
        jceOutputStream.write((Map) this.ratingDistribution, 2);
    }
}
