package com.airbnb.lottie.model;

/* compiled from: P */
/* loaded from: classes.dex */
public class Marker {
    private static final String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    public Marker(String str, float f16, float f17) {
        this.name = str;
        this.durationFrames = f17;
        this.startFrame = f16;
    }

    public float getDurationFrames() {
        return this.durationFrames;
    }

    public String getName() {
        return this.name;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public boolean matchesName(String str) {
        if (this.name.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.name.endsWith(CARRIAGE_RETURN)) {
            String str2 = this.name;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
