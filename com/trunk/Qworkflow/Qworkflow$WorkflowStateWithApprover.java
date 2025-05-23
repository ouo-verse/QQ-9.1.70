package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$WorkflowStateWithApprover extends MessageMicro<Qworkflow$WorkflowStateWithApprover> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_workflow_state", "rpt_msg_approver_list"}, new Object[]{null, null}, Qworkflow$WorkflowStateWithApprover.class);
    public Qworkflow$WorkflowState msg_workflow_state = new Qworkflow$WorkflowState();
    public final PBRepeatMessageField<Qworkflow$Approver> rpt_msg_approver_list = PBField.initRepeatMessage(Qworkflow$Approver.class);
}
