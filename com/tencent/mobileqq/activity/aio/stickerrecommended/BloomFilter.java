package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BloomFilter implements Serializable {
    private final int DEFAULT_SIZE = 2097152;
    private BitSet bits = new BitSet(2097152);
    private SimpleHash[] func;
    private final int[] seeds;
    public String version;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class SimpleHash implements Serializable {
        private int cap;
        private int seed;

        public SimpleHash(int i3, int i16) {
            this.cap = i3;
            this.seed = i16;
        }

        public int hash(String str) {
            int length = str.length();
            int i3 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                i3 = str.charAt(i16) + (this.seed * i3);
            }
            return (this.cap - 1) & i3;
        }
    }

    public BloomFilter() {
        int[] iArr = {5, 31, 1061, 5683, 17239, 25261, 49537};
        this.seeds = iArr;
        this.func = new SimpleHash[iArr.length];
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.seeds;
            if (i3 < iArr2.length) {
                this.func[i3] = new SimpleHash(2097152, iArr2[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    private String a(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public void add(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a16 = a(str);
        for (SimpleHash simpleHash : this.func) {
            this.bits.set(simpleHash.hash(a16), true);
        }
    }

    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a16 = a(str);
        boolean z16 = true;
        for (SimpleHash simpleHash : this.func) {
            if (z16 && this.bits.get(simpleHash.hash(a16))) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }
}
