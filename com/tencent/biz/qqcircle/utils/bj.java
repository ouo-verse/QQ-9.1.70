package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class bj {
    public static Serializable a(byte[] bArr) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serializable serializable = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        return serializable;
    }

    public static <T> int b(List<T> list, T t16) {
        return c(list, f(t16));
    }

    public static <T> int c(List<T> list, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        if (feedCloudMeta$StFeed == null) {
            str = null;
        } else {
            str = feedCloudMeta$StFeed.f398449id.get();
        }
        return d(list, str);
    }

    public static <T> int d(List<T> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return -1;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i(f(list.get(i3)), str)) {
                return i3;
            }
        }
        return -1;
    }

    public static <T> String e(T t16) {
        FeedCloudMeta$StFeed f16 = f(t16);
        if (f16 == null) {
            return null;
        }
        return f16.content.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> FeedCloudMeta$StFeed f(T t16) {
        if (t16 instanceof e30.b) {
            return ((e30.b) t16).g();
        }
        if (t16 instanceof FeedCloudMeta$StFeed) {
            return (FeedCloudMeta$StFeed) t16;
        }
        if (t16 instanceof b40.a) {
            return ((b40.a) t16).e();
        }
        return null;
    }

    public static <T> String g(T t16) {
        FeedCloudMeta$StFeed f16 = f(t16);
        if (f16 == null) {
            return null;
        }
        return f16.f398449id.get();
    }

    public static <T> String h(T t16) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StFeed f16 = f(t16);
        if (f16 != null && (feedCloudMeta$StVideo = f16.video) != null) {
            return feedCloudMeta$StVideo.fileId.get();
        }
        return null;
    }

    private static boolean i(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        return TextUtils.equals(g(feedCloudMeta$StFeed), str);
    }

    public static byte[] j(Serializable serializable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
