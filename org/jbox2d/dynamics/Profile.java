package org.jbox2d.dynamics;

import java.util.List;

/* loaded from: classes29.dex */
public class Profile {
    public float broadphase;
    public float collide;
    public float solve;
    public float solveInit;
    public float solvePosition;
    public float solveTOI;
    public float solveVelocity;
    public float step;

    public void toDebugStrings(List<String> list) {
        list.add("Profile:");
        list.add(" step: " + this.step);
        list.add("  collide: " + this.collide);
        list.add("  solve: " + this.solve);
        list.add("   solveInit: " + this.solveInit);
        list.add("   solveVelocity: " + this.solveVelocity);
        list.add("   solvePosition: " + this.solvePosition);
        list.add("   broadphase: " + this.broadphase);
        list.add("  solveTOI: " + this.solveTOI);
    }
}
