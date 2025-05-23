package org.apache.commons.lang3.time;

import java.util.Date;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes29.dex */
class GmtTimeZone extends TimeZone {
    private static final int HOURS_PER_DAY = 24;
    private static final int MILLISECONDS_PER_MINUTE = 60000;
    private static final int MINUTES_PER_HOUR = 60;
    static final long serialVersionUID = 1;
    private final int offset;
    private final String zoneId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GmtTimeZone(boolean z16, int i3, int i16) {
        char c16;
        if (i3 < 24) {
            if (i16 < 60) {
                int i17 = ((i3 * 60) + i16) * 60000;
                this.offset = z16 ? -i17 : i17;
                StringBuilder sb5 = new StringBuilder(9);
                sb5.append("GMT");
                if (z16) {
                    c16 = '-';
                } else {
                    c16 = '+';
                }
                sb5.append(c16);
                StringBuilder twoDigits = twoDigits(sb5, i3);
                twoDigits.append(':');
                this.zoneId = twoDigits(twoDigits, i16).toString();
                return;
            }
            throw new IllegalArgumentException(i16 + " minutes out of range");
        }
        throw new IllegalArgumentException(i3 + " hours out of range");
    }

    private static StringBuilder twoDigits(StringBuilder sb5, int i3) {
        sb5.append((char) ((i3 / 10) + 48));
        sb5.append((char) ((i3 % 10) + 48));
        return sb5;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GmtTimeZone) || this.zoneId != ((GmtTimeZone) obj).zoneId) {
            return false;
        }
        return true;
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.zoneId;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i3, int i16, int i17, int i18, int i19, int i26) {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.offset;
    }

    public int hashCode() {
        return this.offset;
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i3) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.zoneId + "\",offset=" + this.offset + ']';
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
