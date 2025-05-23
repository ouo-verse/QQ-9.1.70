package org.light.lightAssetKit.components;

import org.light.lightAssetKit.enums.kRigidBody3DShapeType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CollisionShapeData {
    public Vec3 local_position_ = new Vec3();
    public Vec3 local_rotation_ = new Vec3();
    public kRigidBody3DShapeType shape_type_ = kRigidBody3DShapeType.Box;
    public Vec3 box_half_length_ = new Vec3();
    public float sphere_radius_ = 1.0f;
    public float capsule_radius_ = 1.0f;
    public float capsule_height_ = 1.0f;
    public float cylinder_radius_ = 1.0f;
    public float cylinder_height_ = 1.0f;
}
