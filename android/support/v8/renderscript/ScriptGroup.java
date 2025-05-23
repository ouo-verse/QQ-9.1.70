package android.support.v8.renderscript;

import android.support.v8.renderscript.Script;
import android.support.v8.renderscript.ScriptGroupThunker;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class ScriptGroup extends BaseObj {
    IO[] mInputs;
    IO[] mOutputs;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class IO {
        Allocation mAllocation;
        Script.KernelID mKID;

        IO(Script.KernelID kernelID) {
            this.mKID = kernelID;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Node {
        int dagNumber;
        Node mNext;
        Script mScript;
        ArrayList<Script.KernelID> mKernels = new ArrayList<>();
        ArrayList<ConnectLine> mInputs = new ArrayList<>();
        ArrayList<ConnectLine> mOutputs = new ArrayList<>();

        Node(Script script) {
            this.mScript = script;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScriptGroup(int i3, RenderScript renderScript) {
        super(i3, renderScript);
    }

    public void execute() {
        RenderScript renderScript = this.mRS;
        renderScript.nScriptGroupExecute(getID(renderScript));
    }

    public void setInput(Script.KernelID kernelID, Allocation allocation) {
        int i3 = 0;
        while (true) {
            IO[] ioArr = this.mInputs;
            if (i3 < ioArr.length) {
                IO io5 = ioArr[i3];
                if (io5.mKID == kernelID) {
                    io5.mAllocation = allocation;
                    RenderScript renderScript = this.mRS;
                    renderScript.nScriptGroupSetInput(getID(renderScript), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                i3++;
            } else {
                throw new RSIllegalArgumentException("Script not found");
            }
        }
    }

    public void setOutput(Script.KernelID kernelID, Allocation allocation) {
        int i3 = 0;
        while (true) {
            IO[] ioArr = this.mOutputs;
            if (i3 < ioArr.length) {
                IO io5 = ioArr[i3];
                if (io5.mKID == kernelID) {
                    io5.mAllocation = allocation;
                    RenderScript renderScript = this.mRS;
                    renderScript.nScriptGroupSetOutput(getID(renderScript), kernelID.getID(this.mRS), this.mRS.safeID(allocation));
                    return;
                }
                i3++;
            } else {
                throw new RSIllegalArgumentException("Script not found");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        private int mKernelCount;
        private RenderScript mRS;
        private ScriptGroupThunker.Builder mT;
        private ArrayList<Node> mNodes = new ArrayList<>();
        private ArrayList<ConnectLine> mLines = new ArrayList<>();

        public Builder(RenderScript renderScript) {
            if (RenderScript.isNative) {
                this.mT = new ScriptGroupThunker.Builder(renderScript);
            }
            this.mRS = renderScript;
        }

        private Node findNode(Script script) {
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                if (script == this.mNodes.get(i3).mScript) {
                    return this.mNodes.get(i3);
                }
            }
            return null;
        }

        private void mergeDAGs(int i3, int i16) {
            for (int i17 = 0; i17 < this.mNodes.size(); i17++) {
                if (this.mNodes.get(i17).dagNumber == i16) {
                    this.mNodes.get(i17).dagNumber = i3;
                }
            }
        }

        private void validateCycle(Node node, Node node2) {
            for (int i3 = 0; i3 < node.mOutputs.size(); i3++) {
                ConnectLine connectLine = node.mOutputs.get(i3);
                Script.KernelID kernelID = connectLine.mToK;
                if (kernelID != null) {
                    Node findNode = findNode(kernelID.mScript);
                    if (!findNode.equals(node2)) {
                        validateCycle(findNode, node2);
                    } else {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                }
                Script.FieldID fieldID = connectLine.mToF;
                if (fieldID != null) {
                    Node findNode2 = findNode(fieldID.mScript);
                    if (!findNode2.equals(node2)) {
                        validateCycle(findNode2, node2);
                    } else {
                        throw new RSInvalidStateException("Loops in group not allowed.");
                    }
                }
            }
        }

        private void validateDAG() {
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                Node node = this.mNodes.get(i3);
                if (node.mInputs.size() == 0) {
                    if (node.mOutputs.size() == 0 && this.mNodes.size() > 1) {
                        throw new RSInvalidStateException("Groups cannot contain unconnected scripts");
                    }
                    validateDAGRecurse(node, i3 + 1);
                }
            }
            int i16 = this.mNodes.get(0).dagNumber;
            for (int i17 = 0; i17 < this.mNodes.size(); i17++) {
                if (this.mNodes.get(i17).dagNumber != i16) {
                    throw new RSInvalidStateException("Multiple DAGs in group not allowed.");
                }
            }
        }

        private void validateDAGRecurse(Node node, int i3) {
            int i16 = node.dagNumber;
            if (i16 != 0 && i16 != i3) {
                mergeDAGs(i16, i3);
                return;
            }
            node.dagNumber = i3;
            for (int i17 = 0; i17 < node.mOutputs.size(); i17++) {
                ConnectLine connectLine = node.mOutputs.get(i17);
                Script.KernelID kernelID = connectLine.mToK;
                if (kernelID != null) {
                    validateDAGRecurse(findNode(kernelID.mScript), i3);
                }
                Script.FieldID fieldID = connectLine.mToF;
                if (fieldID != null) {
                    validateDAGRecurse(findNode(fieldID.mScript), i3);
                }
            }
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            ScriptGroupThunker.Builder builder = this.mT;
            if (builder != null) {
                builder.addConnection(type, kernelID, fieldID);
                return this;
            }
            Node findNode = findNode(kernelID);
            if (findNode != null) {
                Node findNode2 = findNode(fieldID.mScript);
                if (findNode2 != null) {
                    ConnectLine connectLine = new ConnectLine(type, kernelID, fieldID);
                    this.mLines.add(new ConnectLine(type, kernelID, fieldID));
                    findNode.mOutputs.add(connectLine);
                    findNode2.mInputs.add(connectLine);
                    validateCycle(findNode, findNode);
                    return this;
                }
                throw new RSInvalidStateException("To script not found.");
            }
            throw new RSInvalidStateException("From script not found.");
        }

        public Builder addKernel(Script.KernelID kernelID) {
            ScriptGroupThunker.Builder builder = this.mT;
            if (builder != null) {
                builder.addKernel(kernelID);
                return this;
            }
            if (this.mLines.size() == 0) {
                if (findNode(kernelID) != null) {
                    return this;
                }
                this.mKernelCount++;
                Node findNode = findNode(kernelID.mScript);
                if (findNode == null) {
                    findNode = new Node(kernelID.mScript);
                    this.mNodes.add(findNode);
                }
                findNode.mKernels.add(kernelID);
                return this;
            }
            throw new RSInvalidStateException("Kernels may not be added once connections exist.");
        }

        public ScriptGroup create() {
            ScriptGroupThunker.Builder builder = this.mT;
            if (builder != null) {
                return builder.create();
            }
            if (this.mNodes.size() != 0) {
                for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                    this.mNodes.get(i3).dagNumber = 0;
                }
                validateDAG();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int[] iArr = new int[this.mKernelCount];
                int i16 = 0;
                for (int i17 = 0; i17 < this.mNodes.size(); i17++) {
                    Node node = this.mNodes.get(i17);
                    int i18 = 0;
                    while (i18 < node.mKernels.size()) {
                        Script.KernelID kernelID = node.mKernels.get(i18);
                        int i19 = i16 + 1;
                        iArr[i16] = kernelID.getID(this.mRS);
                        boolean z16 = false;
                        for (int i26 = 0; i26 < node.mInputs.size(); i26++) {
                            if (node.mInputs.get(i26).mToK == kernelID) {
                                z16 = true;
                            }
                        }
                        boolean z17 = false;
                        for (int i27 = 0; i27 < node.mOutputs.size(); i27++) {
                            if (node.mOutputs.get(i27).mFrom == kernelID) {
                                z17 = true;
                            }
                        }
                        if (!z16) {
                            arrayList.add(new IO(kernelID));
                        }
                        if (!z17) {
                            arrayList2.add(new IO(kernelID));
                        }
                        i18++;
                        i16 = i19;
                    }
                }
                if (i16 == this.mKernelCount) {
                    int[] iArr2 = new int[this.mLines.size()];
                    int[] iArr3 = new int[this.mLines.size()];
                    int[] iArr4 = new int[this.mLines.size()];
                    int[] iArr5 = new int[this.mLines.size()];
                    for (int i28 = 0; i28 < this.mLines.size(); i28++) {
                        ConnectLine connectLine = this.mLines.get(i28);
                        iArr2[i28] = connectLine.mFrom.getID(this.mRS);
                        Script.KernelID kernelID2 = connectLine.mToK;
                        if (kernelID2 != null) {
                            iArr3[i28] = kernelID2.getID(this.mRS);
                        }
                        Script.FieldID fieldID = connectLine.mToF;
                        if (fieldID != null) {
                            iArr4[i28] = fieldID.getID(this.mRS);
                        }
                        iArr5[i28] = connectLine.mAllocationType.getID(this.mRS);
                    }
                    int nScriptGroupCreate = this.mRS.nScriptGroupCreate(iArr, iArr2, iArr3, iArr4, iArr5);
                    if (nScriptGroupCreate != 0) {
                        ScriptGroup scriptGroup = new ScriptGroup(nScriptGroupCreate, this.mRS);
                        scriptGroup.mOutputs = new IO[arrayList2.size()];
                        for (int i29 = 0; i29 < arrayList2.size(); i29++) {
                            scriptGroup.mOutputs[i29] = (IO) arrayList2.get(i29);
                        }
                        scriptGroup.mInputs = new IO[arrayList.size()];
                        for (int i36 = 0; i36 < arrayList.size(); i36++) {
                            scriptGroup.mInputs[i36] = (IO) arrayList.get(i36);
                        }
                        return scriptGroup;
                    }
                    throw new RSRuntimeException("Object creation error, should not happen.");
                }
                throw new RSRuntimeException("Count mismatch, should not happen.");
            }
            throw new RSInvalidStateException("Empty script groups are not allowed");
        }

        private Node findNode(Script.KernelID kernelID) {
            for (int i3 = 0; i3 < this.mNodes.size(); i3++) {
                Node node = this.mNodes.get(i3);
                for (int i16 = 0; i16 < node.mKernels.size(); i16++) {
                    if (kernelID == node.mKernels.get(i16)) {
                        return node;
                    }
                }
            }
            return null;
        }

        public Builder addConnection(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            ScriptGroupThunker.Builder builder = this.mT;
            if (builder != null) {
                builder.addConnection(type, kernelID, kernelID2);
                return this;
            }
            Node findNode = findNode(kernelID);
            if (findNode != null) {
                Node findNode2 = findNode(kernelID2);
                if (findNode2 != null) {
                    ConnectLine connectLine = new ConnectLine(type, kernelID, kernelID2);
                    this.mLines.add(new ConnectLine(type, kernelID, kernelID2));
                    findNode.mOutputs.add(connectLine);
                    findNode2.mInputs.add(connectLine);
                    validateCycle(findNode, findNode);
                    return this;
                }
                throw new RSInvalidStateException("To script not found.");
            }
            throw new RSInvalidStateException("From script not found.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ConnectLine {
        Type mAllocationType;
        Script.KernelID mFrom;
        Script.FieldID mToF;
        Script.KernelID mToK;

        ConnectLine(Type type, Script.KernelID kernelID, Script.KernelID kernelID2) {
            this.mFrom = kernelID;
            this.mToK = kernelID2;
            this.mAllocationType = type;
        }

        ConnectLine(Type type, Script.KernelID kernelID, Script.FieldID fieldID) {
            this.mFrom = kernelID;
            this.mToF = fieldID;
            this.mAllocationType = type;
        }
    }
}
