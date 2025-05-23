package n8;

import com.qzone.preview.photodanmaku.entity.AbsDanmaku;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static int b(AbsDanmaku absDanmaku, AbsDanmaku absDanmaku2, long j3) {
        if (absDanmaku.getType() != absDanmaku2.getType() || absDanmaku.isTimeOut() || absDanmaku2.isTimeOut()) {
            return -1;
        }
        return Math.max((int) ((absDanmaku2.getCollisionRectAtTime(absDanmaku.getTime())[0] - absDanmaku.getCollisionRectAtTime(absDanmaku.getTime())[2]) / absDanmaku2.getSpeedX()), (int) ((absDanmaku2.getCollisionRectAtTime(absDanmaku.getEndTime())[0] - absDanmaku.getCollisionRectAtTime(absDanmaku.getEndTime())[2]) / absDanmaku2.getSpeedX()));
    }

    public static int a(AbsDanmaku absDanmaku, AbsDanmaku absDanmaku2) {
        int majorPriority;
        int repeatTime;
        int minorPrioriy;
        int type;
        if (absDanmaku == absDanmaku2) {
            return 0;
        }
        if (absDanmaku == null) {
            return -1;
        }
        if (absDanmaku2 == null) {
            return 1;
        }
        if (absDanmaku.equals(absDanmaku2)) {
            return 0;
        }
        long time = absDanmaku.getTime() - absDanmaku2.getTime();
        if (time > 0) {
            return 1;
        }
        if (time < 0 || (majorPriority = absDanmaku.getMajorPriority() - absDanmaku2.getMajorPriority()) > 0) {
            return -1;
        }
        if (majorPriority < 0 || (repeatTime = absDanmaku.getRepeatTime() - absDanmaku2.getRepeatTime()) > 0) {
            return 1;
        }
        if (repeatTime < 0 || (minorPrioriy = absDanmaku.getMinorPrioriy() - absDanmaku2.getMinorPrioriy()) > 0) {
            return -1;
        }
        if (minorPrioriy < 0) {
            return 1;
        }
        long index = absDanmaku.getIndex() - absDanmaku2.getIndex();
        if (index > 0) {
            return -1;
        }
        if (index < 0) {
            return 1;
        }
        if (absDanmaku.getText() == null) {
            return -1;
        }
        if (absDanmaku2.getText() == null || (type = absDanmaku.getType() - absDanmaku2.getType()) > 0) {
            return 1;
        }
        if (type < 0) {
            return -1;
        }
        return absDanmaku.hashCode() - absDanmaku.hashCode();
    }
}
