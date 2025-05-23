package com.tencent.av.opengl.program;

import qv.a;
import qv.b;
import qv.c;

/* loaded from: classes3.dex */
public class DrawProgram extends TextureProgram {
    public DrawProgram() {
        super("uniform mat4 uMatrix;attribute vec2 aPosition;void main() {vec4 pos = vec4 (aPosition, 0.0, 1.0);gl_Position  = uMatrix * pos;}", "precision mediump float;uniform vec4 uColor;void main() {gl_FragColor = uColor;}", new b[]{new a("aPosition"), new c("uMatrix"), new c("uColor")}, false);
    }
}
