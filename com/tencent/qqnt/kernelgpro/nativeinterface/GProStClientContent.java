package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStClientContent {
    public ArrayList<GProStClientImageContent> clientImageContents = new ArrayList<>();
    public ArrayList<GProStClientVideoContent> clientVideoContents = new ArrayList<>();

    public ArrayList<GProStClientImageContent> getClientImageContents() {
        return this.clientImageContents;
    }

    public ArrayList<GProStClientVideoContent> getClientVideoContents() {
        return this.clientVideoContents;
    }

    public String toString() {
        return "GProStClientContent{clientImageContents=" + this.clientImageContents + ",clientVideoContents=" + this.clientVideoContents + ",}";
    }
}
