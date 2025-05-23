package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.enums.EyeType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EyeSetting {
    public EyeType eyeType;
    public float leftLimit = -0.36f;
    public float rightLimit = 0.36f;
    public float lowerLimit = -0.6f;
    public float upperLimit = 0.6f;
    public float xSensitivity = 2.0f;
    public float ySensitivity = 3.0f;
    public float yOffset = 0.0f;
    public float lookingDownBoost = 2.0f;
    public float innerCanthusTilt = 0.0f;
    public float outerCanthusTilt = 0.0f;
    public ArrayList<Integer> pitchYawRollAxis = new ArrayList<>();
}
