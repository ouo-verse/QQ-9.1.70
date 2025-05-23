package org.light.lightAssetKit.enums;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum fDrawFlags {
    Nodes(1),
    Links(2),
    Faces(4),
    Tetras(8),
    Normals(16),
    Contacts(32),
    Anchors(64),
    Notes(128),
    Clusters(256),
    NodeTree(512),
    FaceTree(1024),
    ClusterTree(2048),
    Joints(4096),
    NodesWithIndex(8192),
    Std(12494),
    StdTetra(12498);

    public int value;

    fDrawFlags(int i3) {
        this.value = i3;
    }
}
