package org.tencwebrtc;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MediaConstraints {
    public final List<KeyValuePair> mandatory = new ArrayList();
    public final List<KeyValuePair> optional = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class KeyValuePair {
        private final String key;
        private final String value;

        public KeyValuePair(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            KeyValuePair keyValuePair = (KeyValuePair) obj;
            if (this.key.equals(keyValuePair.key) && this.value.equals(keyValuePair.value)) {
                return true;
            }
            return false;
        }

        @CalledByNative("KeyValuePair")
        public String getKey() {
            return this.key;
        }

        @CalledByNative("KeyValuePair")
        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.key.hashCode() + this.value.hashCode();
        }

        public String toString() {
            return this.key + MsgSummary.STR_COLON + this.value;
        }
    }

    private static String stringifyKeyValuePairList(List<KeyValuePair> list) {
        StringBuilder sb5 = new StringBuilder("[");
        for (KeyValuePair keyValuePair : list) {
            if (sb5.length() > 1) {
                sb5.append(", ");
            }
            sb5.append(keyValuePair.toString());
        }
        sb5.append("]");
        return sb5.toString();
    }

    @CalledByNative
    List<KeyValuePair> getMandatory() {
        return this.mandatory;
    }

    @CalledByNative
    List<KeyValuePair> getOptional() {
        return this.optional;
    }

    public String toString() {
        return "mandatory: " + stringifyKeyValuePairList(this.mandatory) + ", optional: " + stringifyKeyValuePairList(this.optional);
    }
}
